import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8888);
        System.out.println("Connected to server!");

        BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outputToServer = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        String msgToServer;
        String msgFromServer = "";

        while (true) {
            System.out.print("You: ");
            msgToServer = keyboard.readLine();
            outputToServer.println(msgToServer);

            if (msgToServer.equalsIgnoreCase("quit")) break;

            String line;
            while (!(line = inputFromServer.readLine()).equals("")) {
                
                msgFromServer += line + "\n";
            }
            if (msgFromServer.equalsIgnoreCase("quit")) break;

            System.out.println("Server: " + "\n" + msgFromServer);
            msgFromServer = "";
        }

        socket.close();
        System.out.println("Client closed.");

    }
}
