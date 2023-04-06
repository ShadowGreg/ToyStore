import core.toy.BaseToy;
import core.toy.Toyable;
import core.toy.Toys;
import org.junit.Assert;
import org.junit.Test;

public class ToysTest {
    private Toyable toy;

    private void Setup() {

        toy = new Toys(1, "мяч", 10, 2);
    }

    @Test
    public void getQuantity_test() {
        Setup();
        int expectedQuantity = 2;

        int actualQuantity = toy.getQuantity();

        Assert.assertEquals(expectedQuantity, actualQuantity);
    }

    @Test
    public void compareTo_test() {
        Setup();
        Toys newToy = new Toys(1, "мяч", 10, 2);


        Assert.assertEquals(0, toy.compareTo(newToy));
    }


    @Test
    public void equals_when_the_object_is_null_test() {
        Setup();

        Assert.assertEquals(false, toy.equals(null));
    }

    @Test
    public void equals_when_the_objects_are_equals() {
        Setup();
        Toys newToy = new Toys(1, "мяч", 10, 2);

        Assert.assertEquals(true, toy.equals(newToy));
    }

    @Test
    public void equals_when_the_objects_are_different_class() {
        Setup();
        BaseToy newToy = new BaseToy(1, "мяч", 10);

        Assert.assertEquals(false, toy.equals(newToy));
    }


    @Test
    public void equals_when_the_objects_are_different_Id() {
        Setup();
        Toys newToy = new Toys(3, "мяч", 10, 2);

        Assert.assertEquals(false, toy.equals(newToy));
    }


    @Test
    public void hashCode_test() {
        Setup();
        int expectedHashCode = 160;

        Assert.assertEquals(expectedHashCode, toy.hashCode());
    }
}
