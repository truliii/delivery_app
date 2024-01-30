# 🛵delivery_app
> 스진초 6기 배달 어플 프로젝트

### 📌도메인별 필요한 기능
- User (회원)
  - 회원 가입
  - 로그인
  - 회원 정보 조회
  - 회원 정보 수정
  - 회원 탈퇴
  
    
- Restaurant (식당)
  - 전체 / 음식 카테고리 별 식당 조회
  

- Food (음식)
  - 식당 별 전체 메뉴 조회
  - 각 메뉴의 상세설명 조회
    

- Cart (장바구니)
  - 장바구니 목록 조회
  - 장바구니 메뉴 수량 변경
  - 장바구니 메뉴 삭제
 

- Payment (결제)
  - 결제(주문)
  - 결제(주문) 목록 조회
  - 결제(주문) 취소
  

- Delivery (배달)
  - 배달 현황(준비중, 배달중, 배달완료) 조회
  

- Review (리뷰)
  - 리뷰 작성
  - 리뷰 수정
  - 식당 별 리뷰 조회
  - 회원 별 작성 리뷰 조회
  

### 📌 ERD
[dbdiagram](https://dbdiagram.io/d/DeliveryApp-65a61908ac844320aefed754)  (❕클릭 시 ERD로 이동)

### 📌 REST API 설계
|CRUD| HTTP   | URI         |
|-----|--------|-------------|
|단일 음식 조회| GET    | /foods/{id} |
|단일 음식 등록| POST   | /foods      |
|단일 음식 수정| PATCH  | foods/{id}  |
|단일 음식 삭제| DELETE | foods/{id}  |
|전체 음식 조회| GET    | foods       |
  

### 📌 트러블슈팅
<details>
  <summary>@RequestBody, @ResponseBody 사용 불가</summary>
  spring프로젝트 생성 시 spring web dependency를 추가하지 않아 발생한 문제로 build.gradle에서 spring-starter-web으로 dependency변경
</details>
<details>
  <summary>GET으로 테스트 시 406에러 발생</summary>
  Food클래스에 getter를 추가하니 해결 → 해당 내용은 추가 공부가 필요
</details>

  

