package fileController;

import core.toy.Toyable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    private final String path;

    public WriteFile(String path) {
        this.path = path;
    }

    public void WriteToFile(List<Toyable> toys) {
        JSONArray toyList = new JSONArray();
        for (Toyable toy : toys) {
            JSONObject toyDetails = new JSONObject();
            String[] var = toy.toString().split(";");
            toyDetails.put("id", var[0]);
            toyDetails.put("name", var[1]);
            toyDetails.put("weight", var[2]);
            toyDetails.put("quantity", var[3]);
            toyList.add(toyDetails);
        }
        try {
            FileWriter file = new FileWriter(path);
            file.write(toyList.toJSONString());
            file.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}