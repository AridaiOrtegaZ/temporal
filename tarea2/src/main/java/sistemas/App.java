package sistemas;

import static spark.Spark.*;
import com.google.gson.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        //COURSE
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        
        post("/login", (rq, rs) -> {  //DEVUELVE UN OBJETO JSON 
            // System.out.println("Request: " + rq.queryParams("nombre") + " " +
            // rq.queryParams("pass"));
            String request = rq.body();
            System.out.println("Request: " + request );
            String msj = null;
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse( request );
            JsonObject peticion = arbol.getAsJsonObject();

            Object nombre =  peticion.get("nombre") ;
            // if (rq.queryParams("nombre").equals("root"))
            // msj = "Bienvenido!";
            // else
            // msj = "Usuario equivocado";
            return "Hola post " + nombre + " " + "<a href='//127.0.0.1:5500/formulario.html'>regresar</a>";
        });
        
}
}
