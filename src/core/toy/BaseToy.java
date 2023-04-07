package core.toy;


public class BaseToy {


    protected final int id;
    protected String name;
    protected int weight;

    public BaseToy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int inWeight) {
        this.weight = inWeight;
    }


    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight ;
    }


}
