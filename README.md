>## Shortening

<pre>
 DB 생성과정(Mysql Workbench 기준)
 1. CREATE SCHEMA `musinsa`; 생성
 2. Set Default SCHEMA설정
 3. \src\main\resources\data.sql 파일 위치 SQL실행(Mysql)
</pre>

>## Gradle(주요 사용 Gradle)
* org.springframework.boot
* spring-boot-starter-web
* lombok
* tomcat-embed-jasper
* commons-lang3
* mysql-connector-java
* mybatis-spring-boot-starter
* HikariCP
* spring-boot-devtools

>## Directory 구조

* `src`
    * `java\com\web\musinsa`
        * `config` : 프로젝트 환경 설정
        * `controller` : WEB Controller
        * `model`  
        * `repository` : Mybatis Interface
        * `restController` : Rest API Controller
        * `service` 
        * `utils` 

>## 설명

* Controller
    * "/" (Get) : Main 화면
    * "/{path}" (Get) : 등록된 URL 이동 및 미등록시 알림 페이지 이동
    * "/convertUrl" (Post) : URL 변환

* Base62
    * Index Convert Base62 사용
    