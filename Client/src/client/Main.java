package client;

import java.io.IOException;

public class Main {
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) throws IOException, InterruptedException {
        InputSocketChat chat = new InputSocketChat(SERVER_PORT);
        chat.run();

        BufferSocket buff = new BufferSocket(SERVER_PORT);
        buff.run();
    }
}