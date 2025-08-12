import tcp_package.*;

public class useServer{
    public static void main(String[] args)throws Exception{
        ServerClass obj = new ServerClass(8888);
        obj.RecieveFromClient();
    }
}