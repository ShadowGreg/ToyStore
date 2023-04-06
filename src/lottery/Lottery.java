package lottery;

import core.store.Storeble;
import core.toy.Toyable;

import java.util.List;

public class Lottery {
    private Storeble store;
    private List<Toyable> toys;

    public Lottery(Storeble store) {
        this.store = store;
        this.toys = store.getToys();
    }

}
