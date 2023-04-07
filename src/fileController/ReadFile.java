package fileController;

import core.toy.Toyable;
import core.toy.Toys;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile<T extends Toyable> {
    JSONParser jsonParser;
    private String path;
    private Toyable toy;

    public ReadFile(String path) {
        this.path = path;
        this.jsonParser = new JSONParser();
    }


    public List<Toyable> readJson() {
        List<Toyable> toys = new ArrayList<>();
        try (FileReader reader = new FileReader(path)) {
            Object obj = jsonParser.parse(reader);

            JSONArray toyList = (JSONArray) obj;

            for (Object toy : toyList) {
                JSONObject var = (JSONObject) toy;
                String id = (String) var.get("id");
                String name = (String) var.get("name");
                String weight = (String) var.get("weight");
                String quantity = (String) var.get("quantity");
                toys.add(new Toys(id, name, weight, quantity));
            }

            return toys;

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
