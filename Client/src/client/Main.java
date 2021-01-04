package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Main {
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress host = InetAddress.getLocalHost();

        for(int i = 0; i <= 1024; i++){
            Socket socket = new Socket(host.getHostName(), SERVER_PORT);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            if (i != 1024) {
                objectOutputStream.writeObject(String.format("%o", i));
            } else {
                objectOutputStream.writeObject("Exit");
            }
            objectOutputStream.close();

            Thread.sleep(50);
        }

        System.out.print("This is a Web Socket Client");
    }
}