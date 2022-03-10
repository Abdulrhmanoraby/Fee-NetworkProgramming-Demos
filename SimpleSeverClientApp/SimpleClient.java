import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        System.out.println("Client started");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Socket socket = new Socket("localhost",5050);


        InputStream inputStream = socket.getInputStream();
        DataInputStream socketDIS = new DataInputStream(inputStream);
        String serverMsg = socketDIS.readUTF();
        System.out.println(serverMsg);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream socketDOS = new DataOutputStream(outputStream);
        Scanner sc = new Scanner(System.in);
        System.out.println("write something to your linked server");
        String clientMsg = sc.nextLine();
        socketDOS.writeUTF(clientMsg);
        System.out.println(clientMsg);


        socketDOS.close();
        socketDIS.close();
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
