package ch02.quiz2_2;

// 다음 코드를 실행한 결과는 4, 5, ,6, 42 중 어느 것일까?

public class MeaningOfThis {

    public final int value = 4;

    public void doIt() {
        int value = 6;

        Runnable r = new Runnable() {

            public final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };

        r.run();
    }

    public static void main(String[] args) {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt(); // 이 행의 출력 결과는?

    }
}

// 코드에서 this는 MeaningOfThis가 아니라 Runnable을 참조하므로 5가 정답이다.
