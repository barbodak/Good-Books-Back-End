import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("127.0.0.1", 8000);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());
        dos.writeUTF("login\nusername:u4,,password:567");
        System.out.println(dis.readUTF());
        dos.close();
        s.close();
    }
}
