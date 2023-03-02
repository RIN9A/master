import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private static final int PORT = 34522;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)){
            System.out.println("Сервер запущен и готов к работе...\n");
            while (!server.isClosed()){
                try(
                        Socket socket = server.accept();
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())

                        ){
                    String msg = input.readUTF();
                    System.out.println("К нам пришел " + msg + "\n");
                    output.writeUTF("\nHello, " + msg);
                    int countMsg = 1;
                    String msgAftrGreet = input.readUTF();
                    while (!msgAftrGreet.equals("bye")){
                        if(msg.equals("admin") && msgAftrGreet.equals("exit")){
                            server.close();
                            System.out.println("Работа сервера приостановлена...");
                            break;
                        }
                        System.out.println("Получено сообщение №" + countMsg + " - " + msgAftrGreet+"\n");
                        output.writeUTF("Ответ сервера: " + countMsg + " - " + msgAftrGreet);
                        msgAftrGreet = input.readUTF();
                        countMsg++;
                    }
                    System.out.println("Пока, " + msg);
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
