import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;


public class ChessHttpServer {
    public static void main(String[] args) throws IOException{
        HttpServer server = HttpServer.create(new InetSocketAddress(8080));

        //Main paths of the server
        server.createContext("/chessplayers", new ChessPlayerController());

        //Execute and run server
        server.setExecutor(null);
        System.out.println("Server is running on http://localhost:8080");
        server.start();
    }
    
}
