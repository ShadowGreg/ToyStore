package core.toy;

public class Toys extends BaseToy implements Toyable, Comparable<BaseToy> {

    private int quantity;

    public Toys(int id, String name, int weight, int quantity) {
        super(id, name, weight);
        this.quantity = quantity;
    }

    public Toys(String id, String name, String weight, String quantity) {
        super(Integer.parseInt(id), name,Integer.parseInt(weight));
        this.quantity = Integer.parseInt(quantity);
    }

    @Override
    public int getQuantity() {
        return quantity;
    }


    @Override
    public int compareTo(BaseToy o) {
        return (this.getId() - o.getId());
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Toys other = (Toys) obj;
        if (super.getId()!= other.getId()){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (super.getClass() != null ? this.getId() : 0);
        return hash;
    }

    @Override
    public void ReduceAmount() {
        this.quantity--;
    }

    @Override
    public String toString() {
        return  super.id + ";" + super.name +";" + super.weight + ";" + this.quantity;

    }
}
