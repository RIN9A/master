import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Who are You?");
            String name = scanner.nextLine();
            output.writeUTF(name);
            String recMsg = input.readUTF();
            System.out.println(recMsg);
            String msg;
            while (scanner.hasNext()){
                msg = scanner.nextLine();
                output.writeUTF(msg);
                if(msg.equals("bye")){
                    break;
                }
                recMsg = input.readUTF();
                System.out.println(recMsg);
            }


        }catch (IOException e){
            e.printStackTrace();
        }

    }
}