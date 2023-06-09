import controller.Controller;
import core.toy.Toys;

public class Main {
    static Controller<Toys> controller = new Controller<>("./invoices/1.json", "./droppedPrizes/1.json");

    public static void main(String[] args) {
        try {
            controller.run();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}