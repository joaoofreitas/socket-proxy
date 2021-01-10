package client;

public abstract class SocketParent extends Thread{
    private final int PORT;
    private final String serverIP;

    public SocketParent(int PORT, String serverIP) {
        this.PORT = PORT;
        this.serverIP = serverIP;
    }

    public int getPORT() {
        return PORT;
    }

    @Override
    public String toString() {
        return "Socket{" +
                "PORT=" + PORT +
                '}';
    }
}


