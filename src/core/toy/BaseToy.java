package core.toy;

public class BaseToy {

    private final int id;
    private final String name;
    private int weight;

    public BaseToy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int inWeight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "BaseToy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
