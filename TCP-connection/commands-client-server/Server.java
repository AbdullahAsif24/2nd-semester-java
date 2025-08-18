

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Server{
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);


        Socket socket = serverSocket.accept();


        BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outputToClient = new PrintWriter(socket.getOutputStream(), true);

        String msgFromClient;
        String msgToClient = "";

        while (true) {
            msgFromClient = inputFromClient.readLine();

            if (msgFromClient.equalsIgnoreCase("exit")) break;

            if (msgFromClient.split(" ")[0].equalsIgnoreCase("time")){
                msgToClient = LocalDateTime.now().toString();
            }
            else if (msgFromClient.split(" ")[0].equalsIgnoreCase("Calc")){
                String exp = msgFromClient.substring(msgFromClient.indexOf(" ") + 1);
                // everything after first space

                double result = ExpressionEvaluator.evaluate(exp);

                msgToClient = result + "";


            } else if (msgFromClient.split(" ")[0].equalsIgnoreCase("reverse")) {
                String text = msgFromClient.split(" ")[1];

                String reversed = new StringBuilder(text).reverse().toString();

                msgToClient = reversed;
            }

            System.out.println("Client: " + msgFromClient);

            outputToClient.println(msgToClient);

        }

        socket.close();
        serverSocket.close();
    }
}