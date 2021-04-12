# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 2021-04-07 step2 진행 
- 문자열 계산기 enum구현 부분 복습

## 2021-04-08 step2 진행
- 간단회고 : 인터페이스를 통해 확장한 enum을 넣어주려고 했는데, (~~방법도 어렵고~~)
  생각해보니 enum 안에 상수값을 추가하는게 새로운 enum 만드는 것보다 편한듯..
  
## 2021-04-09 step2 진행 (문자열 계산기 완성)
- 간단회고 : 완성은 했는데 StringCalculator 객체가 너무 많은 역할을 하고 있는 거 같다.
  문자열 분리 역할, 유효성 검사 역할 등 `계산` 외의 기능이 많다. 이 기능들을 분리할 수 있는 방법을
  생각해 보았는데, Expression이라는 객체를 만들어서 수식관련한 문자열 분리, 유효성 검사 등을 담당하게
  하면, 좀 더 객체지향적이지 않을까 하는 생각을 해본다. 또한 Expression은 수식에 대한 내용인데,
  수식에 대한 유효성 검사나 문자열 분리 기능이 요건에 따라서 바뀔 수도 있다고 생각하기 때문에
  해당 기능들은 `인터페이스` 로 구현하여 추후 확장성을 고려하면 더 좋지 않을까 하는 생각을 해보았다.

## 2021-04-10 step2~3 진행
- 문자열 계산기 인터페이스로 구현으로 시도
- step3 시작

## 2021-04-11 step3 진행
- step3 진행

## 2021-04-12 step3 진행
- step3 진행