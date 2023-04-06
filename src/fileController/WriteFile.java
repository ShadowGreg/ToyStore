package fileController;

//import java.io.FileWriter;
//import java.io.IOException;

import org.json.simple.JSONObject;

import java.util.List;

public class WriteFile {
    private String path = "";

    public WriteFile(String path) {
        this.path = path;
    }

    public void WriteFile(List<String> toys){
        try{
            JSONObject sampleObject = new JSONObject();


        } catch (Exception ex){
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