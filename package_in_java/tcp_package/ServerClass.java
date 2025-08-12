
package tcp_package;

import java.io.*;
import java.net.*;

public class ServerClass {

    private Socket socket;
    private ServerSocket serverSocket;

    public ServerClass(int port) throws Exception {
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
        System.out.println("Client connected!");
    }

    public void SendToClient(String msg) throws Exception {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println(msg);

        socket.close();
        serverSocket.close();
        System.out.println("Server closed.");
    }

    public void RecieveFromClient() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String message = in.readLine();
        System.out.println("Client says: " + message);

        socket.close();
        serverSocket.close();
        System.out.println("Server closed.");
    }
}