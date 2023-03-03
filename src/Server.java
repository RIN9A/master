import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Server {
    public static final int PORT = 34522;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            while (true){
                try(
                        Socket socket = serverSocket.accept();
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                        ){
                    String msg = input.readUTF();
                    output.writeUTF("Привет, " + msg);
                    System.out.println("К нам пришел " + msg);
                    String inp = input.readUTF();
                    while (!inp.equals("bye")){

                        System.out.println("Выражение: " + inp);
                        StringTokenizer st = new StringTokenizer(inp);
                        double otv = 0.0;
                        double x = Double.parseDouble(st.nextToken());
                        String op = st.nextToken();
                        double y = Double.parseDouble(st.nextToken());
                        switch (op) {
                            case "-" -> otv = x - y;
                            case "+" -> otv = x + y;
                            case "*" -> otv = x * y;
                            case "/" -> otv = x / y;}
                        System.out.println("Получен ответ");
                        output.writeUTF(Double.toString(otv));
                        inp = input.readUTF();
                    }
                    System.out.println("Пока, " + msg);
                }
                }
            }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
