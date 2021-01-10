package proxy;

public class Main {
    private static final int CLIENT_PORT = 5000;
    private static final int SERVER_PORT = 5001;

    public static void main(String[] args) {
        Proxy proxy = new Proxy("ProxyThread", CLIENT_PORT, SERVER_PORT, "localhost");
        proxy.start();
    }
}