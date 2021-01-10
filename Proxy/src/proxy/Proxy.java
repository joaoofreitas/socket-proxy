package proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Date;

public class Proxy extends Thread{
    private int CLIENT_PORT;
    private int SERVER_PORT;
    private boolean showRaw;

    private String serverIP;


    protected String msg;

    public Proxy(String name, int CLIENT_PORT, int SERVER_PORT, String serverIP) {
        super(name);
        this.CLIENT_PORT = CLIENT_PORT;
        this.SERVER_PORT = SERVER_PORT;
        this.serverIP = serverIP;
        this.showRaw = false;
    }

    public Proxy(String name, int CLIENT_PORT, int SERVER_PORT, String serverIP, boolean showRaw) {
        super(name);
        this.showRaw = showRaw;
        this.CLIENT_PORT = CLIENT_PORT;
        this.SERVER_PORT = SERVER_PORT;
        this.serverIP = serverIP;
    }

    public void runProxy() throws IOException, ClassNotFoundException, InterruptedException {
        ServerSocket server = new ServerSocket(CLIENT_PORT);

        while(true){
            Socket serverSocket = server.accept();
            Socket clientSocket = new Socket(serverIP, SERVER_PORT);

            ObjectInputStream objectInputStream = new ObjectInputStream(serverSocket.getInputStream());

            if(!showRaw) msg = objectInputStream.readObject().toString();
            else msg = Arrays.toString(objectInputStream.readAllBytes());
            objectInputStream.close();

            System.out.printf("[From Client [%s] to Proxy] [%tc] => %s%n", serverSocket.getRemoteSocketAddress(), new Date(), msg);


            ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

            if(msg != null) {
                System.out.format("[From Proxy to Server [%s]] [%tc] => %s%n", serverIP, new Date(),msg);
                objectOutputStream.writeObject(String.format("%s", msg));
                objectOutputStream.close();

                if (msg.equalsIgnoreCase("Exit")) break;
            }
        }
        server.close();
    }

    @Override
    public void run(){
        try {
            runProxy();
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
