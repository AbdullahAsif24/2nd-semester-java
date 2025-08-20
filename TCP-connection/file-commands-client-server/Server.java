import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);

        Socket socket = serverSocket.accept();

        BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outputToClient = new PrintWriter(socket.getOutputStream(), true);

        String msgFromClient;
        String msgToClient = "";

        while (true) {
            msgFromClient = inputFromClient.readLine();

            if (msgFromClient.equalsIgnoreCase("quit"))
                break;

            else if (msgFromClient.split(" ")[0].equalsIgnoreCase("files")) {
                File folder = new File(
                        "E:\\UBIT\\2nd semester\\OOP-Java\\TCP-connection\\file-commands-client-server\\files");

                File[] filesList = folder.listFiles();
                String filesNamesList = "";

                for (File file : filesList) {
                    filesNamesList += (file.getName()) + "\n";
                }

                msgToClient = filesNamesList;
            }

            else if (msgFromClient.split(" ")[0].equalsIgnoreCase("get")) {
                String fileName = msgFromClient.split(" ")[1];

                BufferedReader br = new BufferedReader(new FileReader(
                        "E:\\UBIT\\2nd semester\\OOP-Java\\TCP-connection\\file-commands-client-server\\files\\"
                                + fileName));
                String line = "";
                while ((line = br.readLine()) != null) {

                    if (!line.isEmpty()) {
                        msgToClient += line + "\n";
                    }
                }
            }

            System.out.println("Client: " + msgFromClient);

            outputToClient.println(msgToClient);
            msgToClient = "";

        }

        socket.close();
        serverSocket.close();
        System.out.println("Server Closed");
    }
}
