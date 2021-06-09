import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.json.XML;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {


    public int xmlToJson(String path, String nuevoNombre) throws IOException {
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
        //String jrempExcArr = jrempListaTxt.replaceAll("}],\\{\"EXCHANGES\"","]},\\{\"EXCHANGES\"");
        String jrempListaEXCHArr = jrempListaTxt.replaceAll("],\\{\"EXCHANGES\"", "},\\{\"EXCHANGES\"");
        String jrempExcArr = jrempListaEXCHArr.replaceAll("}},","]}},");
        String ArrFix = jrempExcArr.replaceAll("]]","]");
        String jrempListaFinPla = ArrFix.replaceAll("}},", "},");

        try{
            FileWriter json = new FileWriter(nuevoNombre);
            json.write(jrempListaFinPla);
            json.flush();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error de escritura!");
        }
        return 1;
    };

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Scanner scanRuta = new Scanner(System.in);
        System.out.println("Digite la ruta del XML: ");
        String ruta = scanRuta.nextLine();
        Scanner scanNombreJson = new Scanner(System.in);
        System.out.println("Digite el nombre del nuevo Archivo: ");
        String nombreJson = scanRuta.nextLine();
        main.xmlToJson (ruta, nombreJson);
        System.out.println("Fin del programa");
    }

}
