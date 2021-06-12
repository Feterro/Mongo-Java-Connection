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

//        mongoClient = new MongoClient("localhost", 27017);
//        database = mongoClient.getDB("BDPruebas");
//        collection = database.getCollection("primero");
////        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
////        String lineaJason = bufferedReader.readLine();
//        collection.insert((DBObject) JSON.parse("{\"EXCHANGES\":\"\",\"DATE\":\"26-FEB-1987 15:01:01.79\",\"TOPICS\":{\"D\":\"cocoa\"},\"PEOPLE\":\"\",\"ORGS\":\"\",\"TEXT\":{\"TITLE\":\"BAHIA COCOA REVIEW\",\"BODY\":\"Showers continued throughout the week in\\nthe Bahia cocoa zone, alleviating the drought since early\\nJanuary and improving prospects for the coming temporao,\\nalthough normal humidity levels have not been restored,\\nComissaria Smith said in its weekly review.\\n    The dry period means the temporao will be late this year.\\n    Arrivals for the week ended February 22 were 155,221 bags\\nof 60 kilos making a cumulative total for the season of 5.93\\nmln against 5.81 at the same stage last year. Again it seems\\nthat cocoa delivered earlier on consignment was included in the\\narrivals figures.\\n    Comissaria Smith said there is still some doubt as to how\\nmuch old crop cocoa is still available as harvesting has\\npractically come to an end. With total Bahia crop estimates\\naround 6.4 mln bags and sales standing at almost 6.2 mln there\\nare a few hundred thousand bags still in the hands of farmers,\\nmiddlemen, exporters and processors.\\n    There are doubts as to how much of this cocoa would be fit\\nfor export as shippers are now experiencing dificulties in\\nobtaining +Bahia superior+ certificates.\\n    In view of the lower quality over recent weeks farmers have\\nsold a good part of their cocoa held on consignment.\\n    Comissaria Smith said spot bean prices rose to 340 to 350\\ncruzados per arroba of 15 kilos.\\n    Bean shippers were reluctant to offer nearby shipment and\\nonly limited sales were booked for March shipment at 1,750 to\\n1,780 dlrs per tonne to ports to be named.\\n    New crop sales were also light and all to open ports with\\nJune/July going at 1,850 and 1,880 dlrs and at 35 and 45 dlrs\\nunder New York july, Aug/Sept at 1,870, 1,875 and 1,880 dlrs\\nper tonne FOB.\\n    Routine sales of butter were made. March/April sold at\\n4,340, 4,345 and 4,350 dlrs.\\n    April/May butter went at 2.27 times New York May, June/July\\nat 4,400 and 4,415 dlrs, Aug/Sept at 4,351 to 4,450 dlrs and at\\n2.27 and 2.28 times New York Sept and Oct/Dec at 4,480 dlrs and\\n2.27 times New York Dec, Comissaria Smith said.\\n    Destinations were the U.S., Covertible currency areas,\\nUruguay and open ports.\\n    Cake sales were registered at 785 to 995 dlrs for\\nMarch/April, 785 dlrs for May, 753 dlrs for Aug and 0.39 times\\nNew York Dec for Oct/Dec.\\n    Buyers were the U.S., Argentina, Uruguay and convertible\\ncurrency areas.\\n    Liquor sales were limited with March/April selling at 2,325\\nand 2,380 dlrs, June/July at 2,375 dlrs and at 1.25 times New\\nYork July, Aug/Sept at 2,400 dlrs and at 1.25 times New York\\nSept and Oct/Dec at 1.25 times New York Dec, Comissaria Smith\\nsaid.\\n    Total Bahia sales are currently estimated at 6.13 mln bags\\nagainst the 1986/87 crop and 1.06 mln bags against the 1987/88\\ncrop.\\n    Final figures for the period to February 28 are expected to\\nbe published by the Brazilian Cocoa Trade Commission after\\ncarnival which ends midday on February 27.\\n Reuter\",\"DATELINE\":\"SALVADOR, Feb 26 -\"},\"PLACES\":{\"D\":[\"el-salvador\",\"usa\",\"uruguay\"]}}"));
//        collection.insert((DBObject) JSON.parse("{\"EXCHANGES\":\"\",\"DATE\":\"26-FEB-1987 15:02:20.00\",\"TOPICS\":\"\",\"PEOPLE\":\"\",\"ORGS\":\"\",\"TEXT\":{\"TITLE\":\"STANDARD OIL <SRD> TO FORM FINANCIAL UNIT\",\"BODY\":\"Standard Oil Co and BP North America\\nInc said they plan to form a venture to manage the money market\\nborrowing and investment activities of both companies.\\n    BP North America is a subsidiary of British Petroleum Co\\nPlc <BP>, which also owns a 55 pct interest in Standard Oil.\\n    The venture will be called BP/Standard Financial Trading\\nand will be operated by Standard Oil under the oversight of a\\njoint management committee.\\n\\n Reuter\",\"DATELINE\":\"CLEVELAND, Feb 26 -\"},\"PLACES\":{\"D\":\"usa\"}}"));
//
//        DBCursor dbCursor = collection.find();
//        while (dbCursor.hasNext()){
//            System.out.println(dbCursor.next());
//            System.out.println("\n\n");
//        }
        cargarBaseDatos cargarBaseDatos = new cargarBaseDatos();
        cargarBaseDatos.cargarMongoBD();
    }
}
