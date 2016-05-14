package tests.com.cake.CakeThief;

/**
 * Created by ishishov on 5/14/16.
 */
class CakeType implements Comparable<CakeType> {

    int weight;
    int value;

    public CakeType(int weight, int value) {
        this.weight = weight;
        this.value  = value;
    }

    public double getCost() {
        return ((double)value) / weight;
    }

    @Override
    public int compareTo(CakeType o) {
        return (int) (o.getCost() - this.getCost());
    }

    @Override
    public String toString() {
        return "( " + weight + ", " + value + ", " + getCost() + " )";
    }
}