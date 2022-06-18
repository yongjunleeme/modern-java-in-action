람다 규칙에 맞지 않는 람다 표현식을 고르시오.

1. `() -> {}`
2. `() -> "Raoul"`
3. `() -> { return "Mario"; }`
4. `(Integer i) -> return "Alan" + i;`
5. `(String s) -> {"Iron Man";}`


답: 4. 5번

3) 파라미더가 없으며 (명시적으로 return 문을 이용해서) 문자열을 반환하는 표현식이다.
4) 리턴은 흐름 제어문이다. `(Integer i) -> {return "Alan" +i'}`처럼 되어야 올바른 표현식이다.
5) `"Iron man"`은 구문(statement)이 아니라 표현식(expression)이다. `(String s) -> "Iron Man"`처럼 써야 한다.
