package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class BufferSocket extends SocketParent{
    private final int delay;

    public BufferSocket(int PORT, int delay, String serverIP) {
        super(PORT, serverIP);
        this.delay = delay;
    }

    protected void runSocket() throws IOException, InterruptedException  {
        InetAddress host = InetAddress.getLocalHost();

        for(int i = 0; i <= 1024; i++) {
            Socket socket = new Socket(host.getHostName(), this.getPORT());

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            if (i != 1024) objectOutputStream.writeObject(String.format("%o", i));

            objectOutputStream.close();
            Thread.sleep(delay);
        }
    }

    @Override
    public void run(){
        try {
            runSocket();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
