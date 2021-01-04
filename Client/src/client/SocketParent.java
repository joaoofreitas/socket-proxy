package client;

public class SocketParent {
    private final int PORT;

    public SocketParent(int PORT) {
        this.PORT = PORT;
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


