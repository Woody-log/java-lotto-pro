# 로또

## 진행 방법

* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 3단계 - 로또(수동)

### 요구사항

1. 구입금액을 입력한다.
    * null 또는 빈문자 체크
    * 숫자가 아닌 값 체크
    * 1000원 이하 금액 체크
    * 1000원 단위로 로또 생성, 잔돈은 무시한다
   
2. 당첨번호 입력
    * null 또는 빈문자 체크
    * 입력한 숫자의 갯수가 6개인지 체크
    * 중복된 값 체크
    * 숫자가 아닌 문자 체크
    * 1~45 사이의 숫자인지 체크

3. 당첨 통계
    * 당첨번호와 구입한 로또번호를 비교하여 일치하는 숫자 카운트
    * 일치하는 숫자 카운트에 따라 각 3,4,5,6개 일치값을 카운트 