package lottery;

import core.store.Storeble;
import core.toy.Toyable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {
    private Storeble store;
    private List<Toyable> toys;
    private List<Toyable> arrayForGetToys;

    private Random rnd;

    public Lottery(Storeble store) {
        this.store = store;
        this.toys = store.getToys();
        FillArrayToys(this.toys);
    }

    public Toyable GetToy(){
        int toyIndex = rnd.nextInt(arrayForGetToys.size());
        return store.GetToy(arrayForGetToys.get(toyIndex));
    }

    private void FillArrayToys(List<Toyable> toys) {
        arrayForGetToys = new ArrayList<>();
        for (Toyable item : toys) {
            for (int i = 0; i < item.getWeight(); i++) {
                arrayForGetToys.add(item);
            }
        }
    }
}
