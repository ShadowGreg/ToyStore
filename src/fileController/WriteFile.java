package fileController;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    private String path = "";

    public WriteFile(String path) {
        this.path = path;
    }

    public void WriteText(String text) {
        try (FileWriter writer = new FileWriter(this.path, true)) {
            writer.write(text);
            writer.append('\n');

            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}