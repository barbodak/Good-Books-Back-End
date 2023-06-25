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
            String request = dis.readUTF();
            Scanner sc = new Scanner(request);
            //parsing
            String command = sc.nextLine();
            String data = sc.nextLine();
            // responding
            String responce = new Controller().run(command, data);
            dos.writeUTF(responce);
            dos.flush();
            // closing
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e){}
    }
}
