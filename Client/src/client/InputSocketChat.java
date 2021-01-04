package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class InputSocketChat extends SocketParent{
    public InputSocketChat(int PORT) {
        super(PORT);
    }

    public void run() throws IOException, InterruptedException {
        InetAddress host = InetAddress.getLocalHost();

        while(true) {

            Scanner msg = new Scanner(System.in);

            Socket socket = new Socket(host.getHostName(), this.getPORT());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            objectOutputStream.writeObject(msg.nextLine());
            objectOutputStream.close();

            Thread.sleep(5);
        }
    }
}
