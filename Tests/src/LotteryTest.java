import core.store.Store;
import core.toy.Toyable;
import core.toy.Toys;
import lottery.Lottery;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LotteryTest {

    private Lottery lottery;
    private final List<Toyable> toys = Arrays.asList(
            new Toys(1, "меч", 10, 13),
            new Toys(2, "трэк", 30, 1),
            new Toys(3, "поезд", 50, 10),
            new Toys(4, "мяч", 10, 25)
    );

    private void Setup() {
        Store store = new Store(toys);
        lottery = new Lottery(store);
    }

    @Test
    public void createLottery_test() {
        Setup();

        Assert.assertNotNull(lottery);
    }

    @Test
    public void cGetToy_test() {
        Setup();

        Toyable toy = lottery.GetToy();

        Assert.assertNotNull(toy);
    }
}
