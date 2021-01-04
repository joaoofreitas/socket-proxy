package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ServerSocket server = new ServerSocket(PORT);

        while(true){
            Socket socket = server.accept();
            if(!socket.isConnected()) System.out.println("Waiting for client to connect...");
            else {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                String msg = (String) objectInputStream.readObject();
                System.out.printf("[%s] => %s%n", socket.getRemoteSocketAddress(), msg);
                objectInputStream.close();

                if (msg.equalsIgnoreCase("Exit")) break;
            }
        }
        System.out.println("Shutting down the socket...");
        server.close();
    }
}