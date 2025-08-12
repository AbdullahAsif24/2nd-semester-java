package tcp_package;


import java.io.*;
import java.net.*;

public class ClientClass {
    private Socket socket;

    public ClientClass(String ip, int port) throws Exception{
        socket = new Socket(ip, port);
    }
    
    public void send(String msg) throws Exception {

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println(msg);

        socket.close();
        out.close();

    }

    public void getResponse() throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String response = in.readLine();
        System.out.println("Server :" + response);

        socket.close();
        in.close();
    }

    
}