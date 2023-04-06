package core.toy;

public class Toys extends BaseToy implements Toyable {

    private int quantity;

    public Toys(int id, String name, int weight, int quantity) {
        super(id, name, weight);
        this.quantity = quantity;
    }

    @Override
    public int getQuantity() {
        return 0;
    }
}
