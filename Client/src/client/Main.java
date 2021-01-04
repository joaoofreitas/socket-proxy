package client;

import java.io.IOException;

public class Main {
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        InputSocketChat chat = new InputSocketChat(SERVER_PORT);
        chat.start();

        BufferSocket buff = new BufferSocket(SERVER_PORT, 100);
        buff.start();
    }
}