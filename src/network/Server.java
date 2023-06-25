package network;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void start() throws Exception {
        ServerSocket ss = new ServerSocket(8000);
        while (true) {
           Socket socket = ss.accept();
           new ClientHandler(socket).start();
        }
    }
}
