package ch03.quiz3_2;

public class FunctionInterface {

    // 다음 중 함수형 인터페이스는 어느 것인가?

    public interface Adder {
        int add(int a, int b);
    }

    public interface SmartAdder extends Adder {
        int add(double a, double b);
    }

    public interface Nothing {
    }


    // Adder만 함수형 언터페이스다.
    // 함수형 인터페이스는 하나의 추상 메서드를 지정하는 인터페이스다.

    // SmartAdder는 두 개의 추상 add 메서드(하나는 Adder에서 상속받음)를
    // 포함하므로 함수형 인터페이스가 아니다.

}
