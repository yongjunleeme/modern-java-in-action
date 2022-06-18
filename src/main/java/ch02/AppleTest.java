package ch02;

import java.util.ArrayList;
import java.util.List;

public class AppleTest {

    enum Color {
        RED,
        GREEN
    }

    public static class Apple {
        private int weight = 0;
        private Color color;

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color=" + color +
                    '}';
        }
    }

    interface ApplePredicate {
        boolean test(Apple a);
    }

    public class AppleHeavyWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    public static class AppleGreenColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return Color.GREEN.equals(a.getColor());
        }
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        System.out.println("result = " + result);
        return result;
    }

    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple(1, Color.GREEN));
        list.add(new Apple(1, Color.RED));

        filterApples(list, new AppleGreenColorPredicate());
    }
}
