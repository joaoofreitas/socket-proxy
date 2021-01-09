package proxy;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerForward extends Thread{
    private int PORT;
    protected String msg;

    public ServerForward(int PORT) {
        this.PORT = PORT;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void run(){
        try {
            runProxy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void runProxy() throws IOException, InterruptedException {
        InetAddress host = InetAddress.getLocalHost();

        Socket clientSocket = new Socket(host.getHostName(), PORT);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

        if(msg != null) {
            System.out.format("[ServerForward] => %s%n", msg);
            objectOutputStream.writeObject(String.format("%s", msg));
            objectOutputStream.close();
        }
        Thread.sleep(5);
    }
}
