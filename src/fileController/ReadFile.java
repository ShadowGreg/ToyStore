package fileController;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class ReadFile {
    private JSONObject jsonObject;
    private String path;

    public ReadFile(String path) throws Exception {
        this.path = path;
        this.jsonObject = (JSONObject) readJsonSimpleDemo(path);
    }


    public Object readJsonSimpleDemo(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }
}
