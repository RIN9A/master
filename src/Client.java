import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 34522;
    public static void main(String[] args) {
        try(
        Socket socket = new Socket(SERVER_ADDRESS,SERVER_PORT);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ){
            System.out.println("Who are you?");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            output.writeUTF(name);
            String recMsg = input.readUTF();
            System.out.println(recMsg);
            System.out.println("Введите математическое выражение : число знак число \n" );
            String mt;
            while (scanner.hasNext()){
            mt = scanner.nextLine();
            output.writeUTF(mt);
            if(mt.equals("bye")){
                break;
            }
            String ans = input.readUTF();
            System.out.println("Ответ: " + ans);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}