package ch02;

import java.util.ArrayList;
import java.util.List;

public class ListAbstraction {
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

    public interface Predicate<T> {
        boolean test(T t);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(1, Color.GREEN));
        inventory.add(new Apple(1, Color.RED));

        List<Apple> redApples = filter(inventory, (Apple apple)
                -> Color.RED.equals(apple.getColor()));

        System.out.println("redApples = " + redApples);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        List<Integer> evenNumbers = filter(numbers, (Integer i) -> i % 2 != 0);

        System.out.println("evenNumbers = " + evenNumbers);

    }
}
