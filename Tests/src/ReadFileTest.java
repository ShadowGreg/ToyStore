import fileController.ReadFile;
import fileController.WriteFile;
import org.junit.Assert;
import org.junit.Test;

public class ReadFileTest {
    private String path;
    private ReadFile readFile;

    private void Setup() throws Exception {
        path = "1.json";
        readFile = new ReadFile(path);
    }

    @Test
    public void ReadFile_test() throws Exception {
        Setup();


        Assert.assertNotNull(readFile);
    }


    @Test
    public void readJson_test() throws Exception {
        Setup();

        Object var =  readFile.readJsonSimpleDemo(path);

        Assert.assertNotNull(readFile);
    }

}
