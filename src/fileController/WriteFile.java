package fileController;

//import java.io.FileWriter;
//import java.io.IOException;

import core.toy.Toyable;
import core.toy.Toys;
import org.json.simple.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class WriteFile {
    private String path = "";

    public WriteFile(String path) {
        this.path = path;
    }

    public void WriteFile(List<Toyable> toys) {
        try {
            JSONObject sampleObject = new JSONObject();
            for (Toyable toy : toys) {
                String[] var = toy.toString().split(";");
                sampleObject.put("id", var[0]);
                sampleObject.put("name", var[1]);
                sampleObject.put("weight", var[2]);
                sampleObject.put("quantity", var[3]);
                Files.write(Path.of(path), sampleObject.toJSONString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

//    public void WriteText(String text) {
//        try (FileWriter writer = new FileWriter(this.path, true)) {
//            writer.write(text);
//            writer.append('\n');
//
//            writer.flush();
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
}