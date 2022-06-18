package ch03;

public class Apple {
    private int weight = 0;

    public Apple(int weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return String.valueOf(weight);
    }



    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
