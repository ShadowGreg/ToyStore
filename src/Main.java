import controller.Controller;
import core.Toy;
import view.View;

public class Main {
    public static void main(String[] args) {
        new Controller(new View(), new Toy()).run();
    }
}