import controller.Controller;
import core.toy.BaseToy;
import view.View;

public class Main {
    public static void main(String[] args) {
        new Controller<BaseToy>(new View()).run();
    }
}