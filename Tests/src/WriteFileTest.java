import core.toy.Toyable;
import core.toy.Toys;
import fileController.WriteFile;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WriteFileTest {
    private List<Toyable> toys = Arrays.asList(
            new Toys(1, "меч", 10, 13),
            new Toys(2, "трэк", 30, 1),
            new Toys(3, "поезд", 50, 10),
            new Toys(4, "мяч", 10, 25)
    );
    private String path;

    private WriteFile writeFile;

    private void Setup() {
        this.path = "1.json";
        this.writeFile = new WriteFile(this.path);
    }

    @Test
    public void WriteFile_test() {
        Setup();

        writeFile.WriteToFile(toys);

        Assert.assertNotNull(toys);
    }

}
