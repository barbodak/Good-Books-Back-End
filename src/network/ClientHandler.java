package network;

import controller.Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread{
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // getting the sreames
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            // receiving request
            StringBuilder request = new StringBuilder();
            int c = dis.read();
            while (c != 0) {
                request.append((char) c);
                c = dis.read();
            }
            System.out.println(request.toString());
            Scanner sc = new Scanner(request.toString());
            //parsing
            String command = sc.nextLine();
            String data = sc.nextLine();
            // responding
            String responce = new Controller().run(command, data);
            System.out.println(responce);
            dos.writeBytes(responce);
            dos.flush();
            // closing
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e){}
    }
}
