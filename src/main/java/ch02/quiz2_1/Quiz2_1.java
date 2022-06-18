package ch02.quiz2_1;

import java.util.ArrayList;
import java.util.List;

public class Quiz2_1 {

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

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color=%s, weight=%d}", color, weight);
        }

    }

    public interface AppleFormatter {
        String accept(Apple apple);
    }

    public static class AppleFancyFormatter implements AppleFormatter {
        public String accept(Apple apple) {
            String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
            return "A " + characteristic + " " + apple.getColor() + " apple";
        }
    }

    public static class AppleSimpleFormatter implements AppleFormatter {
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(1, Color.GREEN));
        apples.add(new Apple(1, Color.RED));

        prettyPrintApple(apples, new AppleFancyFormatter());

        prettyPrintApple(apples, new AppleSimpleFormatter());
    }
}
