package core.toy;


public interface Toyable {
    public int getWeight();

    public void setWeight(int inWeight);

    public int getQuantity();

    public int compareTo(BaseToy o);

    public boolean equals(Object obj);

    public int hashCode();

    public void ReduceAmount();
}
