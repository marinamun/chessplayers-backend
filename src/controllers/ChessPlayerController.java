import java.io.IOException;
import java.net.HttpURLConnection;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.util.ArrayList;
import java.util.List;
import models.ChessPlayer;


public class ChessPlayerController implements HttpHandler {
    private final List<ChessPlayer> chessPlayers = new ArrayList<>();

    //dummy data to test the routes, in constructor
    public ChessPlayerController() {
        chessPlayers.add(new ChessPlayer(1, "Magnus Carlsen", "Norway", 2800, 2859, 2882, 33, "Sicilian Defense", 1, "GM", "photo_url"));
        chessPlayers.add(new ChessPlayer(2, "Ian Nepomniachtchi", "Russia", 2750, 2783, 2792, 32, "Ruy Lopez", 2, "GM", "photo_url"));
        chessPlayers.add(new ChessPlayer(3, "Ding Liren", "China", 2780, 2811, 2830, 30, "Queen's Gambit", 3, "GM", "photo_url"));

    }

    private void getAllChessPlayers(HttpExchange exchange) throws IOException{
        //HTTP response nees json array(string format). thats why i use stringbuilder.      

        //create the string and start it with a "[" of json array of objects
        StringBuilder response = new StringBuilder("[");
        for (ChessPlayer player: chessPlayers){
            response.append(player.toJson()).append(",");
        }
        //little clean up after all players added to our json array, remove last comma
        if (response.length()<1){
            response.setLength(response.length()-1);
        }
        //close the array with "]"
        response.append("]");

        //exchange is an instance of httpExchange, connects server and client
        sendResponse(exchange, 200, response.toString());

    }
    private void getChessPlayerById(HttpExchange exchange, String path) throws IOException{
        //get the id from the path/url and make it a number
        int id = Integer.parseInt(path.substring(path.lastIndexOf("/")+1));

        //find the chessplayer. stream() to search and perform operations. filter, stop at the first match. if no match, null.
        ChessPlayer player = chessPlayers.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        
        //handle the result
        if (player != null){
            sendResponse(exchange, 200, player.toJson());
        } else{
            sendResponse(exchange, 404, "Chess player not found");
        }
    } 

    private void sendResponse(HttpExchange exchange, int statusCode, String responseText) throws IOException{
        exchange.sendResponseHeaders(statusCode, responseText.getBytes().length);
        try (var os = exchange.getResponseBody()) {
            os.write(responseText.getBytes());
        }
    }

    //time to define when to call each function, for this override the default handle function of httphandler
    @Override
    public void handle(HttpExchange exchange) throws IOException{
        String method = exchange.getRequestMethod(); //to get the http method
        String path = exchange.getRequestURI().getPath(); // for the route endpoint

        if(method.equalsIgnoreCase("GET")){
            // If the path matches "/chessplayers/{id}"
            if(path.matches("/chessplayers/\\d+")){
                getChessPlayerById(exchange, path);
            // If the path is "/chessplayers"
            } else if (path.equals("/chessplayers")){
                getAllChessPlayers(exchange);
            }else{
                sendResponse(exchange, 404, "Invalid path");
            }
        } else{
            sendResponse(exchange, 405, "We don't handle this HTTP method");
        }
    }
}
