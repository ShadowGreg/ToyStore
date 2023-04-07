package core.toy;


public interface Toyable {
    int getWeight();

    void setWeight(int inWeight);

    int getQuantity();

    int compareTo(BaseToy o);

    boolean equals(Object obj);

    int hashCode();

    void ReduceAmount();

    String toString();
}
