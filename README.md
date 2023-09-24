# 🏪 BackEnd 프로젝트

## 👀 서비스 소개
- 서비스명 : Trip Serivice
- 서비스설명 : 지역별로 여행에 관한 정보를 제공한다.

## 📅 프로젝트 기간
- 2023.09.24 ~ 2023.09.24 

## ⭐ 주요 기능
지역별 관광지 정보 수집
관광지, 문화시설, 축제공연행사,여행,레포츠,숙박,쇼핑,음식점 등으로 조회
회원 관리 기능
로그인 관리
게시판 기능

## 기본기능

### 1. 메인 페이지 및 메뉴 구성
![image](https://github.com/dev1week/enjoyTrip/assets/119592507/3b3cb06a-cb34-4283-a9ef-f7ceec86d60c)

- 메인 화면 구성
    - 로그인 카드 : 로그인, 회원가입, 여행 계획 만들기 
    - navbar : 여행기록, 마이페이지, 로그아웃 

### 2. 관광지 정보 조회
![image](https://github.com/dev1week/enjoyTrip/assets/119592507/6cc52ae0-9fb6-4a30-8c17-234a93646b2b)
![image](https://github.com/dev1week/enjoyTrip/assets/119592507/1006b347-6405-4219-a7ab-de16da2d4267)

- 컨텐츠 아이디별 검색 가능 
- 지역별 검색 가능 

### 3. 회원 정보 페이지

#### 1) 회원 가입
![image](https://github.com/dev1week/enjoyTrip/assets/119592507/e44aff8b-ec50-4e56-ae04-39ab6f0fee3b)
![image](https://github.com/dev1week/enjoyTrip/assets/119592507/f08716ea-08c7-4fb6-80bf-d9372bc26759)


- 메인페이지에서 회원가입 클릭 시 이동
- 회원가입 기능 구현 

#### 2) 회원 정보 조회
![image](https://github.com/dev1week/enjoyTrip/assets/119592507/9746309e-f6fa-4fb5-a7d6-287b5df040b8)


- 로그인 시 navbar에서 이동 가능
- 마이페이지 이동 시 회원 정보 조회
- 비밀번호는 뜨지 않게 처리.

#### 3) 회원 정보 수정
![image](https://github.com/dev1week/enjoyTrip/assets/119592507/7ddeb701-66b1-4115-b966-12d7ecef60f8)


- 마이페이지에서 수정 버튼을 클릭시 회원 정보 수정 가능
- 아이디를 제외한 비밀번호, 이름, 이메일 수정 가능 
- 수정 버튼을 누르면 비밀번호를 뜨게 처리.

#### 4) 회원 정보 삭제(탈퇴)
![image](https://github.com/dev1week/enjoyTrip/assets/119592507/dbda3850-4b91-45fe-b2f4-c1b62871c9d7)


- 마이페이지에서 탈퇴 버튼을 누르면 회원 정보 탈퇴 가능
- 탈퇴 시 메인 화면으로 돌아감.

#### 5) 로그인 / 로그아웃
![image](https://github.com/dev1week/enjoyTrip/assets/119592507/f08716ea-08c7-4fb6-80bf-d9372bc26759)

- 메인 화면에서 아이디, 비밀번호 입력 후 로그인 버튼 클릭 
- 로그인되었을 경우 navbar 변경
- 로그인이 된 상태에서 navbar에 있는 로그아웃 버튼 클릭 시 로그아웃 기능.


- 검색 후 결과 지도 마킹 기능

### 6. 검색결과 표시 후 드래그 하여 계획에 포함
![Screen Recording - Sep 8, 2023](https://github.com/dev1week/with-dog/assets/119592507/a4c019a7-1ff4-4c67-999a-ba561d25e91e)
![image](https://github.com/dev1week/with-dog/assets/119592507/bb6f1346-74e7-4712-8e77-80c1a800fa32)
![image](https://github.com/dev1week/with-dog/assets/119592507/582a7764-ee92-4e73-9e70-fef5d4e6bb95)




- 검색 후 좌측 화면에 검색 결과 표현
- 마음에 드는 지역을 드래그하여 계획에 추가가능

### 7. 여행 계획 경로 설정 (계획은 로컬스토리지 저장)
![image](https://github.com/dev1week/with-dog/assets/119592507/849bcf7e-9e73-4054-9f2b-7aca2070f23a)



- 오른쪽 상단에 계획으로 넣어놓은 장소는 이름과 주소를 배열로 저장하여 **local storage에 저장**

### 8. 최종 여행 계획 표시
![image](https://github.com/dhflxhdxhd/with-dog/assets/52151533/44f08d1e-daa2-4c36-aeb8-e832fe2b9c91)



## 👨‍💻팀원 소개

- 김아현
- 김한주
