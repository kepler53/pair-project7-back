## 백엔드 구조

    ├── happyhouse_final
    │   ├── src/main/java
    |   │   ├── com
    |   |   │   ├── ssafy
    |   |   |   │   ├── hapyhouse
    |   |   |   |   │   ├── config
    |   |   |   |   |   │   ├── WebConfiguration.java - Cors와 관련 된 Header를 허용시켜주는 config 파일
    |   |   |   |   |   │   └── WebSecurityConfig.java - BcrptPasswordEncoder를 bean으로 등록시키고, jwt를 담고 있지 않는 요청 중 허락해 줄 요청을 설정하는 config
    |   |   |   |   │   ├── controller
    |   |   |   |   |   │   ├── AdminController.java - 관리자 계정으로 할 수 있는 요청을 모아둔 컨트롤러
    |   |   |   |   |   │   ├── BoardController.java - 게시판 관련 CRUD 컨트롤러
    |   |   |   |   |   │   ├── JwtAuthenticationController.java - 사용자 인증을 위한 컨트롤러 -jwt 토큰반환
    |   |   |   |   |   │   ├── MapController.java - 프론트의 맵의 해당하는 요청을 위한 컨트롤러
    |   |   |   |   |   │   └── UserController.java - 회원관리를 위한 컨트롤러
    |   |   |   |   │   ├── dto
    |   |   |   |   |   │   ├── BoardDto.java -게시판 dto
    |   |   |   |   |   │   ├── ConvenienceDto.java - 매물 주변의 정보를 담은 dto
    |   |   |   |   |   │   ├── HouseAddDto.java - 매물 추가시 필요한 정보를 담기 위한 dto
    |   |   |   |   |   │   ├── HouseDealDto.java - 매매 매물과 관련된 dto
    |   |   |   |   |   │   ├── HouseRentDto.java - 전세,월세 매물과 관련된 dto
    |   |   |   |   |   │   ├── HouseInfo.java - 매매 매물의 정보가 담긴 dto
    |   |   |   |   |   │   ├── JwtResponse.java - jwt를 반환할 때 사용하는 dto
    |   |   |   |   |   │   ├── LegalCodeDto.java - 법정동에 해당하는 코드와 시구동을 반환하기 위한 dto
    |   |   |   |   |   │   ├── MapDto.java - 위경도를 반환하기 위한 dto
    |   |   |   |   |   │   ├── PreferenceDto.java - 회원의 관심사항을 저장하기 위한 dto
    |   |   |   |   |   │   └── UserDto.java - 회원의 정보를 저장하기 위한 dto
    |   |   |   |   │   ├── error
    |   |   |   |   |   │   └── ErrorAdvice.java - controller,service에서 발생한 error를 handling하기 위한 controlleradvice
    |   |   |   |   │   ├── filter
    |   |   |   |   |   │   └── JwtRequestFilter.java - bearer token으로 들어왔는지, 유저정보가 존재하는 지를 판단하기 위한 필터
    |   |   |   |   │   ├── mapper
    |   |   |   |   |   │   ├── BoardMapper.java - 게시판 관련 mapper
    |   |   |   |   |   │   ├── HouseMapper.java - 매물 정보를 가져오거나 추가하기를 위해 구현된 mapper
    |   |   |   |   |   │   ├── PreProcessMapper.java - 데이터를 전처리하기 위한 mapper
    |   |   |   |   |   │   ├── StoreMapper.java - 상점 정보를 얻기 위한 mapper
    |   |   |   |   |   │   ├── UserMapper.java - 사용자의 crud를 하기 위한 mapper
    |   |   |   |   |   │   ├── board-mapper.xml - 위의 해당 mapper의 기능과 동일
    |   |   |   |   |   │   ├── house-mapper.xml - 위의 해당 mapper의 기능과 동일
    |   |   |   |   |   │   ├── preprocess-mapper.xml - 위의 해당 mapper의 기능과 동일
    |   |   |   |   |   │   ├── store-mapper.xml - 위의 해당 mapper의 기능과 동일
    |   |   |   |   |   │   └── user-mapper.xml - 위의 해당 mapper의 기능과 동일
    |   |   |   |   │   ├── service
    |   |   |   |   |   │   ├── BoardService.java - 게시판 관련된 service
    |   |   |   |   |   │   ├── BoardServiceImpl.java - BoardService의 구현체, 게시판 기능담당
    |   |   |   |   |   │   ├── ConvenienceService.java - 편의시설 관련된 service
    |   |   |   |   |   │   ├── ConvenienceServiceImpl.java - ConvenienceService 구현체, 게시판 기능담당
    |   |   |   |   |   │   ├── HouseService.java - 매물과 관련된 Service
    |   |   |   |   |   │   ├── HouseServiceImpl.java - HouseService 구현체
    |   |   |   |   |   │   ├── MapService.java - 맵과 관련된 Service
    |   |   |   |   |   │   ├── MapServiceImpl.java - MapService구현체
    |   |   |   |   |   │   ├── PreProcessService.java - 데이터 전처리를 위한 service
    |   |   |   |   |   │   ├── PreProcessServiceImpl.java - PreProcessService 구현체
    |   |   |   |   |   │   ├── UserService.java - 회원 관리를 위한 service
    |   |   |   |   |   │   └── UserServiceImpl.xml - UserService 구현체
    |   |   |   |   │   └── util
    |   |   |   |   |   │   ├── JwtAuthenticationEntryPoint.java : token이 존재하지 않을 시 401 에러를 반환하는 entrypoint
    |   |   |   |   |   │   └── JwtTokenUtil.java : jwt 생성하고 만료를 판단하는 util
    |   |   |   |   |   └── ...
    └── ...

-   src/main/resources/application.properties : server의 port 번호, dbcp pool에 관한 설정, mapper 등록, jwt secret key의 값을 등록해주었습니다.
-   pom.xml : spring security, mybatis, mysqldriver, spring web, lombok, json-simple(json parser를 사용하기 위해), commons-dbcp2, transaction(tx),
    jsonwebtoken(jwt), jsoup(java crawling 관련)

## 기술 스택

### Front-end

-   Vue
-   Vuex
-   Vue-naver-maps

### Back-end

-   Spring boot
-   Naver Map geocoding
-   Naver Map reverse-geocoding
-   Spring security

## 소감

데이터를 가공하는 데 문제가 여러 개 있었습니다. 그리고 contoller 단에서 처리하지 말아야 할 것들을 아직 남겨두어서 추가적으로 쉬는 날에 service단으로 내려야 합니다.
그리고 여러 데이터를 만지는 데 index를 생성하고 covered index query를 날려서 query의 실행 속도를 줄이려고 하였지만 크게 줄지 않았어서 쿼리를 날리는 것이 아니라
전처리를 해야하는 점이 아쉬웠습니다. 그리고 시간이 부족하여 대출 관련 기능, 뉴스 크롤링하여서 데이터 뿌리는 기능을 구현하지 못한 것도 아쉽습니다. 그 외에 여러 오류를 처리하는 데 처음 보는 오류에 대해서 판단하는 능력이 부족했던 점이 존재하므로 쉬는 동안 공부를 진행해야 할 것 같습니다.
