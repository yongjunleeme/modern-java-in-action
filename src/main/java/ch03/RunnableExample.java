package ch03;

import java.util.function.Function;

public class RunnableExample {

    public static void process(Runnable r){
        r.run();
    }

    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("hi 1");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hi 2");
            }
        };

        process(r1);
        process(r2);
        process(() -> System.out.println("hi 3"));
    }
}
