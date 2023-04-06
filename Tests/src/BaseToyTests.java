import core.toy.BaseToy;
import org.junit.Assert;
import org.junit.Test;

public class BaseToyTests {
    private BaseToy toy;

    private void Setup() {
        toy = new BaseToy(1, "мяч", 10);
    }


    @Test
    public void createToy_test() {
        Setup();

        Assert.assertNotNull(toy);
    }

    @Test
    public void getId_test() {
        Setup();
        int expectedId = 1;

        int actualId = toy.getId();

        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void getWeight_test() {
        Setup();
        int expectedWeight = 10;

        int actualWeight = toy.getWeight();

        Assert.assertEquals(expectedWeight, actualWeight);
    }

    @Test
    public void setWeight_test(){
        Setup();
        int expectedWeight = 14;

        toy.setWeight(expectedWeight);
        int actualWeight = toy.getWeight();

        Assert.assertEquals(expectedWeight, actualWeight);
    }

    @Test
    public void toString_test(){
        Setup();
        String expectedText = "id=1, name='мяч', weight=10";

        String actualText = toy.toString();

        Assert.assertEquals(expectedText, actualText);
    }

}
