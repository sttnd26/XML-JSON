import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

class JsonParse {

    public static void main(String[] args){

        JSONParser parser = new JSONParser();
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try{
            URL url = Resources.getResource("employeeJSON.json");
            String text = Resources.toString(url, Charsets.UTF_8);
            Object obj = parser.parse(text);
            JSONArray array = (JSONArray)obj;

            fout = new FileOutputStream("parsedjson.txt");
            oos = new ObjectOutputStream(fout);

            System.out.println("JSON Objects:");
            for (int i=0;i<3;i++)
            {
                System.out.println(array.get(i));

                oos.writeObject(array.get(i));
            }

        }
        catch(ParseException pe){

            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
