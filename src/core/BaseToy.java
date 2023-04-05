package core;

public abstract class BaseToy {
    int id;
    int weight;
    String name;

    public BaseToy(int id, int weight, String name) {
        this.id = id;
        this.weight = weight;
        this.name = name;
    }

    @Override
    public String toString() {
        return "BaseToy{" +
                "id=" + id +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
