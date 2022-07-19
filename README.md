# Blog_project
--------------------------------------------------------

### ⎊ 프로젝트 설명

--------------------------------------------------------
* **설명** : **Hibernate**를 활용한 Blog 사이드 프로젝트


### ⎊ 주요 기술 스택

--------------------------------------------------------

> * **Version** : Java 1.8
> * **DataBase** : mariaDB
> * **Framework** : Hibernate
> * **WebServer** : Tomcat 9.0
> * **Application Interface** : JPA



### ⎊ DB Structure

--------------------------------------------------------

![](https://velog.velcdn.com/images/hyeongwoo26/post/3b91dd24-2d79-40d1-be59-4a5a7a430d1a/image.png)
* **"blog_project.spl"** 에  DDL로 작성

### ⎊ 주요 기능 설명

--------------------------------------------------------


#### 1. 로그인 시
1. 회원가입 및 로그인
   1. 이메일 중복체크, 비밀번호 체크
   2. 회원가입 후, 해당 이메일로 회원가입 확인(Token 발행) 관련한 메일 발송
      1. 이메일 확인 전, email_tokens > state = 0(비회원) 등록
      2. 이메일 확인 후, email_tokens > state = 1(회원) 변환
   2. 포스트 CRUD 전체 사용 가능
   3. 댓글 CRUD 전체 사용 가능
   4. 태그 C,R 사용 가능

#### 2. 비 로그인 시
1. 포스트 CRUD 전체 사용 가능
   1. 단, 비로그인으로 글 작성 시, 글의 비밀번호 입력 예정
      * DB의 추후 등록 예정
   2. 글 등록 시, 비밀번호로 제한적으로 활용 예정

#### 3. 공용
1. 비밀번호 분실 시, 해당 이메일로 발생

--------------------------------------------------------

