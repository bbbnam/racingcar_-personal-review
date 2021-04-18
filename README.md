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

## 2021-04-14 step3 진행
- 간단회고 : 결국 도메인 로직들은 개별 단위별로 구현을 했는데, 뷰와 합치는 부분에서
또 애매해진다. 결합하는 부분이 항상 어색하다.

## 2021-04-15 step3 진행
- 간단회고 : 그리기를 위해서는 게임이 전부 진행되고 난 결과를 가져오는게 아니라 진행할때마다
리스트에 저장해서 가져오든지, 그리면서 진행이 되든지 둘중 하나의 방식으로 해야 한다.
나는 일단 기존 구현하던게 한번에 진행하던거여서 굳이 바꾸자면 진행할때마다 리스트에 저장하는 편이 쉬워서
그렇게 진행하였다.

## 2021-04-18 리뷰 받은 내용 정리
1. GameConsole에 비즈니스 로직이 있는데 service로 두면 좋을까?
2. 팩토리 패턴이 꼭 필요할까?
3. 커스텀 Exception을 사용했는데 엄밀히 따지면 IllegalStateException을 받는건 어떨까?
4. CarNames의 필요성?
5. MoveStatgy를 생성자로 받을 필요는? -> 추후 generator가 바뀔 걸 고려했는데, 굳이?
6. NumberGenerator의 필요성?
7. Position 불변으로 하는게 낫지 않을까?
8.  findWinner 에서 List<Cars>를 받는데 Cars만 받아도 되지 않을까?
9. Contests에서 Stream으로 변수를 두었는데, 컬렉션으로 바꾸기 
(스트림은 한번 사용하면 닫힘 -> 동일 메소드 두번 호출하면 해당 스트림 못 불러온다는 뜻)
10. getter 사용 줄이기
11. 인터페이스 하나면 FunctionalInterface 사용하기
12. Car의 move메소드에서 position 값을 가져와서 다시 계산하고 다시 넣는데, 애초에 그냥 Position에서 처리하게
가능하지 않을까?
13.  Scanner 같은 경우도 외부에서 넣어주게 하는게 좋다고 함 -> 내부에서 선언하면 한번 사용하고 두번째는 안되는 오류? 같은게 있을 수도..
14. Winners 클래스에 finalRecords.getCars() 이것 리팩토링 필요해 보임
15. getPosition 부분도...
16. findWinner 마지막 new ArrayList 불필요
17. RandomGeneratorTest  필요한가? Random 클래스를 검증하는 것밖에...