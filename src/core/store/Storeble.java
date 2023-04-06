package core.store;

import core.toy.Toyable;

import java.util.List;

public interface Storeble {

    public List<Toyable> getToys();

    public Toyable GetToy(Toyable inToy);

}
