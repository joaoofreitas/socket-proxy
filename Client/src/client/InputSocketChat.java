package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class InputSocketChat extends SocketParent{
    public InputSocketChat(int PORT, String serverIP) {
        super(PORT, serverIP);
    }

    protected void runSocket() throws IOException {
        InetAddress host = InetAddress.getLocalHost();

        while(true) {
            Scanner msg = new Scanner(System.in);

            Socket socket = new Socket(host.getHostName(), this.getPORT());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            objectOutputStream.writeObject(msg.nextLine());
            objectOutputStream.close();
        }
    }

    @Override
    public void run(){
        try {
            runSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
