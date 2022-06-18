package ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CustomFunction {
    public static void main(String[] args) {

        // 참고 : https://stackoverflow.com/questions/27872387/can-a-java-lambda-have-more-than-1-parameter

        // 불리언 표현식
        Function<List<String>, Boolean> identity = (List<String> list) -> list.isEmpty();

        List<String> emptyList = new ArrayList<>();
        System.out.println(identity.apply(emptyList));

        // 객체 생성
        Function<Integer, Apple> createApple = (i) -> new Apple(i);

        System.out.println(createApple.apply(10));

        Runnable createApple2 = () -> new Apple(11);

        System.out.println(createApple2);


        // 객체에서 선택/추출
        Function<String, Integer> toLength = (String s) -> s.length();

        System.out.println(toLength.apply("hi"));


        // 두 값을 조합
        TwoParameterFunctionByReturn<Integer,Integer> multiply = (a, b) -> a * b;

        System.out.println("multiply = " + multiply.apply(2,2));

    }

    @FunctionalInterface
    public interface TwoParameterFunctionByReturn<T, U> {
        public T apply(T t, U u);
    }

}
