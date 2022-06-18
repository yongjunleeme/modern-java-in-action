package ch03;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest {

    // 출처: https://youtu.be/KoFvKTjBNds

    // functional interface : 인터페이스인데 abstract method가 하나만 존재

    // Mapper Function: T -> R 다른 타입을 반환
    // Identity Function : T -> T 그냥 받아서 그냥(같은 타입) 리턴
    // Consumer : T -> void

    public static void main(String[] args) {

        Function<String, Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };

        // toInt와 같음
        Function<String, Integer> toInt2 = s -> Integer.parseInt(s);

        final Integer number = toInt.apply("100");
        final Integer number2 = toInt2.apply("100");
        System.out.println("function = " + number);
        System.out.println("lambda = " + number2);

        // Identity
        final Function<Integer, Integer> identity = Function.identity();

        System.out.println("identity = " + identity.apply(100));

        // Consumer
        final Consumer<String> print = new Consumer<String>() {
            @Override
            public void accept(String value) {
                System.out.println(value);
            }
        };

        final Consumer<String> print2 = value -> System.out.println(value);
        print2.accept("hi2");
        print.accept("hi");

        // Supplier : lazy evaluation

        long start = System.currentTimeMillis();


        // todo: try catch

//        printIfValidIndex(0, () -> getVeryExpensiveValue());
//        printIfValidIndex(-1, () -> getVeryExpensiveValue());
        printIfValidIndex(-2, () -> {
            try {
                return getVeryExpensiveValue();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return e.toString();
            }
        });

        System.out.println("It took " + ((System.currentTimeMillis() - start) / 1000) + " seconds");



    }

    private static String getVeryExpensiveValue() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        return "hi";
    }

    private static void printIfValidIndex(int number, Supplier<String> valueSupplier) {
        if (number >= 0) {
            System.out.println("The value is" + valueSupplier.get() + ".");
        } else {
            System.out.println("Invalid");
        }
    }

}
