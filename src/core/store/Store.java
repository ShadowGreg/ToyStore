package core.store;

import core.toy.Toyable;

import java.util.List;

public class Store implements Storeble {
    private final List<Toyable> toys;


    public Store(List<Toyable> toys) {
        this.toys = toys;
        FillShelvesToys(toys);
    }

    private void FillShelvesToys(List<Toyable> toys) {
    }

    public void AddToy(Toyable inToy) {
        this.toys.add(inToy);        
    }

    public int GetToyQuantity() {
        return this.toys.size();
    }
}
