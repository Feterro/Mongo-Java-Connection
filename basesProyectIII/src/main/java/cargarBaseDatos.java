import com.mongodb.*;
import com.mongodb.util.JSON;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.ArrayList;

public class cargarBaseDatos {

    public  MongoClient mongoClient;
    public  DB database;
    public  DBCollection collection;

    public cargarBaseDatos() {}

    public ArrayList<String> listarJason(String jason){
        String[] listaArticulos = jason.split("},[{]");
        ArrayList<String> articulos = new ArrayList<>();
        for (String articulo: listaArticulos){
            if (articulo.equals(listaArticulos[0])){
                articulo = articulo + "}";
                articulos.add(articulo);
            }
            else if (articulo.equals(listaArticulos[listaArticulos.length-1])){
                articulo = "{" + articulo;
                articulos.add(articulo);
            }
            else{
                articulo = "{" + articulo + "}";
                articulos.add(articulo);
            }
        }
        return articulos;
    }

    public boolean insertarJason(ArrayList<String> articulos, String nombreColeccion) throws UnknownHostException {

        mongoClient = new MongoClient("localhost", 27017);
        database = mongoClient.getDB("basesIIproyecto");
        collection = database.getCollection(nombreColeccion);

        for(String articulo: articulos){
            collection.insert((DBObject) JSON.parse(articulo));
        }

        return collection.getCount() > 0;
    }

    public String convertirXML_JSON(String path) throws IOException {

        File xml = new File(path);
        byte[] b = Files.readAllBytes(xml.toPath());
        String xmlStr = new String(b);
        String xrempREU = xmlStr.replaceAll("<REUTERS.*>","<REUTERS>");
        String xrempUnk = xrempREU.replaceAll("<UNKNOWN>\\n*\\s*[^<]*\\n*\\s*</UNKNOWN>","");
        String xrempMKN = xrempUnk.replaceAll("<MKNOTE>\\n*\\s*[^<]*\\n*\\s*</MKNOTE>","");
        String xrempComp = xrempMKN.replaceAll("<COMPANIES>\\n*\\s*[^<]*\\n*\\s*</COMPANIES>","");
        JSONObject jsonObj = XML.toJSONObject(xrempComp);
        String jsonStr = jsonObj.toString();
        String jrempIni = jsonStr.replaceAll("\\{\\n*\\s*\"COLLECTION\":\\{\\n*\\s*\"REUTERS\":\\[\\n*\\s*\\{", "{");
        String jrempFin = jrempIni.replaceAll("}\\n*\\s*]\\n*\\s*}\\n*\\s*}", "}");
        String jrempListaIni = jrempFin.replaceAll("\\{\\n*\\s*\"D\":\\[\"|\\{\\n*\\s*\"D\":\"", "[\"");
        String jrempListaFin = jrempListaIni.replaceAll("},", "],");
        String jrempListaTxt = jrempListaFin.replaceAll("],\\n*\\s*\"PLACES\"", "},\"PLACES\"");
        String jrempListaEXCHArr = jrempListaTxt.replaceAll("],\\{\"EXCHANGES\"", "},\\{\"EXCHANGES\"");
        String jrempExcArr = jrempListaEXCHArr.replaceAll("}},","]}},");
        String ArrFix = jrempExcArr.replaceAll("]]","]");
        String jrempListaFinPla = ArrFix.replaceAll("}},", "},");

        return jrempListaFinPla;
    }

    public void cargarMongoBD() throws IOException {
        System.out.println("Dijite la ruta del directorio XML: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();

        System.out.println("Dijite el nombre de la colección que desea crear: ");
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String coleccionNombre = bufferedReader.readLine();

        String JSON = convertirXML_JSON(path);
        ArrayList<String> articulos = listarJason(JSON);
        insertarJason(articulos, coleccionNombre);
        System.out.println("Los artículos fueron insertados en la base de datos");



    }
}
