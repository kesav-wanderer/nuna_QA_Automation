import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class JsonReader {
    public String getField(String field) throws IOException, ParseException {
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("src/main/resources/InputData.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        return (String) jo.get(field);
    }
    public String getPageObjects(String elementName) throws IOException, ParseException {
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("src/main/resources/pageObjects.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        return (String) jo.get(elementName);
    }

}
