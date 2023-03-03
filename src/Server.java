import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private static final int PORT = 34522;
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен и готов к работе...\n");
            while (true) {
                Session session = new Session(server.accept());
                session.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}

class Session extends Thread{
    private final Socket socket;

    public Session(Socket socket){
        this.socket = socket;
    }




    public void run(){
        try (
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ){

            String msg = input.readUTF();
            System.out.println("К нам пришел " + msg + "\n");
            output.writeUTF("\nHello, " + msg);
            int countMsg = 1;
            String msgAftrGreet = input.readUTF();
            while (!msgAftrGreet.equals("bye")){
                System.out.println("Получено сообщение №" + countMsg + " - " + msgAftrGreet+"\n");
                output.writeUTF("Ответ сервера: " + countMsg + " - " + msgAftrGreet);
                msgAftrGreet = input.readUTF();
                countMsg++;
            }
            System.out.println("Пока, " + msg);
            socket.close();
        } catch (IOException e){
        e.printStackTrace();
        }
    }

    }




