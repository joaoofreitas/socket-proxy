package client;

public class Main {
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        // InputSocketChat chat = new InputSocketChat(SERVER_PORT, "localhost");
        // chat.start();

        BufferSocket buffer = new BufferSocket(SERVER_PORT, 100, "localhost");
        buffer.start();

        BufferSocket buffer2 = new BufferSocket(SERVER_PORT, 20, "localhost");
        buffer2.start();
    }
}