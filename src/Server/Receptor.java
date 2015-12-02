package Server;

import java.net.Socket;
import java.net.*;
import Data.Data;

public class Receptor {

    private int port = 1337;
    protected static Data data = new Data();

    public Receptor(int port) {
        if(port > -1) {
            this.port = port;
        }
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while(true) {
                System.out.println("test");
                final Socket client = serverSocket.accept();
                new Thread() {
                    public void run() {
                        new Server(client, data);
                    }
                }.start();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
