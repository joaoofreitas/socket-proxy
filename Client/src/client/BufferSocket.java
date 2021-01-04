package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class BufferSocket extends SocketParent{

    public BufferSocket(int PORT) {
        super(PORT);
    }

    public void run() throws IOException, InterruptedException {
        InetAddress host = InetAddress.getLocalHost();

        for(int i = 0; i <= 1024; i++) {
            Socket socket = new Socket(host.getHostName(), this.getPORT());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            if (i != 1024) objectOutputStream.writeObject(String.format("%o", i));
            objectOutputStream.close();

            Thread.sleep(50);
        }
    }
}
