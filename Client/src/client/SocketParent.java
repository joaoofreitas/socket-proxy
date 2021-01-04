package client;

import java.io.IOException;

public class SocketParent extends Thread{
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


