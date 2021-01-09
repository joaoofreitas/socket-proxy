package proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Proxy extends Thread{
    private int CLIENT_PORT;
    private int SERVER_PORT;
    private String msg;

    public Proxy(int CLIENT_PORT, int SERVER_PORT) {
        this.CLIENT_PORT = CLIENT_PORT;
        this.SERVER_PORT = SERVER_PORT;
    }

    public void runProxy() throws IOException, ClassNotFoundException, InterruptedException {
        ServerSocket server = new ServerSocket(CLIENT_PORT);
        ServerForward serverForward = new ServerForward(SERVER_PORT);

        while(true){
            Socket serverSocket = server.accept();

            ObjectInputStream objectInputStream = new ObjectInputStream(serverSocket.getInputStream());
            msg = (String) objectInputStream.readObject();
            objectInputStream.close();


            Date date = new Date();
            System.out.printf("[Proxy] [%s] [%tc] => %s%n", serverSocket.getRemoteSocketAddress(), date, msg);
            
            serverForward.setMsg(msg);
            serverForward.runProxy();

            if (msg.equalsIgnoreCase("Exit")) break;
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
