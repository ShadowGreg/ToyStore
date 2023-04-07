import core.toy.Toyable;
import core.toy.Toys;
import fileController.ReadFile;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ReadFileTest {
    private String path;
    private ReadFile readFile;

    private List<Toyable> expectedList = Arrays.asList(
            new Toys(1, "меч", 10, 13),
            new Toys(2, "трэк", 30, 1),
            new Toys(3, "поезд", 50, 10),
            new Toys(4, "мяч", 10, 25)
    );

    private void Setup() throws Exception {
        path = "1.json";
        readFile = new ReadFile<Toys>(path);
    }

    @Test
    public void ReadFile_test() throws Exception {
        Setup();


        Assert.assertNotNull(readFile);
    }

    @Test
    public void readJson_test() throws Exception {
        Setup();

        List<Toyable> actualList =  readFile.readJson();

        Assert.assertNotNull(actualList);

    }


    @Test
    public void readJson_and_expectedList_are_Equals_test() throws Exception {
        Setup();

        List<Toyable> actualList =  readFile.readJson();

        Assert.assertArrayEquals(new List[]{expectedList}, new List[]{actualList});

    }

}
