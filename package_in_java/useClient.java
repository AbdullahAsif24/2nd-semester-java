import tcp_package.*;

public class useClient{
    public static void main(String[] args)throws Exception{
        ClientClass obj = new ClientClass("localhost", 8888);
        obj.send("hello from client");
    }
}