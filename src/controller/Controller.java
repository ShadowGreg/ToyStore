package controller;

import core.toy.Toyable;
import view.Viewable;

public class Controller<T extends Toyable> {
    private Viewable view;
    private Toyable toy;

    public Controller(Viewable view) {
        this.view = view;
    }

    public void run() {

    }
}
