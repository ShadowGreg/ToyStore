package controller;

import core.BaseToy;
import view.Viewable;

public class Controller<A extends Viewable, B extends BaseToy > {
    Viewable view;
    BaseToy toy;

    public Controller(Viewable view, BaseToy toy) {
        this.view = view;
        this.toy = toy;
    }

    public void run(){

    }
}
