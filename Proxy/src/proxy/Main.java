package proxy;

public class Main {
    private static final int CLIENT_PORT = 5000;
    private static final int SERVER_PORT = 5001;

    public static void main(String[] args) throws InterruptedException{
        Proxy proxy = new Proxy(CLIENT_PORT, SERVER_PORT);
        proxy.start();

        Thread.sleep(5);
    }
}