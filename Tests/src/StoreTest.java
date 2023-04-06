import core.store.Store;
import core.toy.Toyable;
import core.toy.Toys;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StoreTest {

    private Store store;
    private List<Toyable> toys = Arrays.asList(
            new Toys(1, "меч", 10, 13),
            new Toys(2, "трэк", 30, 1),
            new Toys(3, "поезд", 50, 10),
            new Toys(4, "мяч", 10, 25)
    );

    private void Setup() {
        store = new Store(toys);
    }

    @Test
    public void createStore_test() {
        Setup();

        Assert.assertNotNull(store);
    }

    @Test
    public void getToys_test() {
        Setup();
        List<Toyable> expectedToys = toys;

        List<Toyable> actualToys = store.getToys();

        Assert.assertArrayEquals(new List[]{expectedToys}, new List[]{actualToys});
    }

    @Test
    public void GetToy_test() {
        Setup();
        Toyable expectedToy = new Toys(4, "мяч", 10, 25);

        Toyable actualToy = store.GetToy(expectedToy);

        Assert.assertEquals(expectedToy, actualToy);
    }

    @Test
    public void GetToy_when_is_the_last_toy_in_queue_test() {
        Setup();
        Toyable expectedToy = new Toys(2, "трэк", 30, 1);

        Toyable actualToy = store.GetToy(expectedToy);

        Assert.assertEquals(expectedToy, actualToy);
    }


    @Test
    public void GetToy_when_is_the_null_toy_in_queue_test() {
        Setup();
        Toyable expectedToy = new Toys(2, "трэк", 30, 1);

        Toyable actualToy = store.GetToy(expectedToy);
        actualToy = store.GetToy(expectedToy);

        Assert.assertEquals(null, actualToy);
    }

    @Test
    public void AddToy_test() {
        Setup();
        Toyable newToy = new Toys(5, "мяч", 15, 25);
        List<Toyable> expectedToys = Arrays.asList(
                new Toys(1, "меч", 10, 13),
                new Toys(2, "трэк", 30, 1),
                new Toys(3, "поезд", 50, 10),
                new Toys(4, "мяч", 10, 25),
                new Toys(5, "мяч", 15, 25)
        );

        store.AddToy(newToy);
        List<Toyable> actualToys = store.getToys();

        Assert.assertArrayEquals(new List[]{expectedToys}, new List[]{actualToys});
    }
}
