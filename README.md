# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## step1 - String 클래스에 대한 학습 테스트
### 요구사항1
* "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 테스트
* "1"을 ,로 split 했을 때 1만 포함하는 배열이 반환되는지에 대한 테스트
> 배열 확인 
>* contains()활용
>* containsExactly()활용

### 요구사항2
* "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()를 제거 -> "1,2" 반환

### 요구사항3
* "abc" 값이 주어졌을 때 String의 chatAt() 메소드를 활용해 특정 위치의 문자를 가져오는 테스트 구현
* String의 charAt() 메소드를 활용하여 특정 위치 문자 가져올 때, 위치값 벗어나면 StringIndexOutOfBoundsException 발생 테스트
* @DisplayName 활용

## Set Collection에 대한 학습 테스트
### 요구사항1
* Set의 size() 메소드 활용 -> Set 크기 확인 테스트

### 요구사항2
* Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인 테스트
* JUnit의 ParameterizedTest를 활용 -> 중복코드 제거

### 요구사항3
* contains 메소드 결과값이 true 말고 다른 결과값이 경우에도 테스트 가능하도록
* ex> 1,2,3 값은 contains 실행하면 true / 4,5 일 때는 false 되도록 (@CsvSource를 활용)

## step2 - 문자열 계산기
### 기능 요구사항
* 사용자 입력값(문자열)에 따라 사칙연산 수행 계산기 구현
* 입력 문자열 중 <숫자>와 <사칙연산> 사이에는 반드시 빈 공백 문자열 있다고 가정
* 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정
* 사칙연산의 계산 우선순위가 아닌 입력 값 순서에 따른 계산
* ex) 2 + 3 * 4 / 2 의 결과 값은 10

### 프로그래밈 요구사항
* 메소드가 너무 많은 일을 하지 않도록 분리

### 기능 분리 힌트
* 테스트 할 수 있는 단위로 나누어 구현 목록 만들기
* 입력값이 null 또는 빈 공백 문자일 경우 IllegalArgumentException
* 사칙연산 기호가 아닌 경우 IllegalArgumentException 
* 사칙연산을 모두 포함하는 기능 구현
* 공백 문자 분리시 split(" ")활용
* 반복적인 패턴 -> 반복문 구현