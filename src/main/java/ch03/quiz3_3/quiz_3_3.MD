
다음 중 표현식을 올바로 사용한 코드는?
1)
```java
execute(()) -> {});
public void execute(Runnable r) {
    r.run;
}
```

2)
```java
pubilc Callable<String> fetch() {
    return () -> "Tricky example ;-)";
}
```

3)
```java
Predicate<Apple> p = (Apple a) -> a.getWeight();
```


3번만 틀림

`(Apple a) -> a.getWeight()`의 시그니처는 `(Apple) -> Integer`이므로
`Predicate<Apple>: (Apple) -> boolean`의 test 메서드의 시그니처와 일치하지 않는다.
