import com.mongodb.*;
import com.mongodb.util.JSON;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class mongoDB {

    public static MongoClient mongoClient;
    public static DB database;
    public static DBCollection collection;



    public static void main (String[] args) throws IOException {

        cargarBaseDatos cargarBaseDatos = new cargarBaseDatos();
        cargarBaseDatos.cargarMongoBD();

    }
}

//C:\Users\Crystel Montero\Documents\Universidad\2021\I semestre\Bases II\Proyectos\proyecto III\2021-1 TP3 - Noticias Reuters - MongoDB\reuters21578