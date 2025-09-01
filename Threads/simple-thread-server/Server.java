import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Server started. Waiting for clients...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress());

            // Start a new thread for this client
            ClientHandler handler = new ClientHandler(socket);
            handler.start();  
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader inputFromClient = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter outputToClient = new PrintWriter(socket.getOutputStream(), true);

            String msgFromClient;
            String msgToClient = "End";

            while ((msgFromClient = inputFromClient.readLine()) != null) {
                if (msgFromClient.equalsIgnoreCase("quit")) {
                    break;
                } else {
                    System.out.println(msgFromClient);
                }

                outputToClient.println(msgToClient);
            }

            socket.close();
            System.out.println("Client disconnected: " + socket.getInetAddress());

        } catch (Exception e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}
