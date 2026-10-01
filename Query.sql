# 2026-09-30 db 실습 예제
# 1. desk 라는 테이블에 shelf 라는 열을 추가하는데 문자열 (20)이다.
# 2. 데이터를 추가한다. item = rice, note = hot, shelf = a
# 3. 전체를 조회한다.
# 4. note가 hot인 데이터를 조회하는데 item, shelf 열만 조회하라.

ALTER TABLE desk
    ADD shelf VARCHAR(20);

INSERT INTO desk(item, note, shelf)
VALUES ('rice', 'hot', 'a');

SELECT *
FROM desk;

SELECT item, shelf
FROM desk
WHERE note = 'hot';

ALTER TABLE desk
    ADD opened_at DATETIME;

INSERT INTO desk (item, desk.opened_at)
VALUES ('lunch', '2026-09-30 10:45:00');

SELECT *
FROM desk;

# 3. 과제 - 1
USE kdt;

CREATE TABLE project_team
(
    id        Int         NOT NULL AUTO_INCREMENT,
    team_code VARCHAR(20) NOT NULL,
    team_name VARCHAR(30) NOT NULL,
    opened_at DATETIME,
    PRIMARY KEY (id),
    UNIQUE (team_code)
);

CREATE TABLE project_application
(
    id         INT AUTO_INCREMENT NOT NULL,
    team_id    INT                NOT NULL,
    applicant  VARCHAR(20)        NOT NULL,
    applied_at DATETIME,
    PRIMARY KEY (id),
    FOREIGN KEY (team_id) REFERENCES project_team (id)
);

DESCRIBE project_team;

DESCRIBE project_application;

SHOW CREATE TABLE project_team;

SHOW CREATE TABLE project_application;

# 3. 과제 2. 정상 데이터와 두 무결성 오류를 같은 상태에서 검증하기
# 1. backend 와 database 팀을 추가합니다. id는 입력하지 않습니다.
INSERT INTO project_team(team_code, team_name, opened_at)
VALUES ('backend', '민수', '2026-09-30 11:31:00');

INSERT INTO project_team(team_code, team_name, opened_at)
VALUES ('database', '지수', '2026-09-30 11:31:00');

# 2. 각 팀의 실제 id를 조회합니다.
SELECT *
FROM project_team;

# 3. 같은 backend 코드를 다시 추가하여 오류 코드 1062를 확인합니다.
INSERT INTO project_team(team_code, team_name, opened_at)
VALUES ('backend', '민수', '2026-09-30 11:31:00');

# 4. 조회한 실제 번호로 민수와 지수의 신청을 각각 추가합니다.
INSERT INTO project_application(team_id, applicant, applied_at)
VALUES (1, '민수', '2026-11-01 20:00:00');

INSERT INTO project_application(team_id, applicant, applied_at)
VALUES (2, '지수', '2026-11-02 20:00:00');

# 5. 신청 수를 기록한 뒤, project_team에 없는 번호로 신청을 시도하여 오류 코드 1452를 확인합니다.
SELECT COUNT(*) AS 신청수
FROM project_application;

SELECT *
FROM project_application;

# 오류 발생
INSERT INTO project_application (team_id, applicant, applied_at)
VALUES (999, '유령', '2025-11-01 20:00:00');


# 오류 전후 신청 수가 같고, 정상 신청 두 건만 남았는지 확인합니다.
SELECT *
FROM project_application;

# 과제 3. 운영 중 열 추가와 부모 행 보호를 연속으로 확인하기
# 1. DESCRIBE project_application;을 실행합니다. memo 열이 없을 때만 memo VARCHAR(30) 열을 추가합니다.
DESCRIBE project_application; # DESCRIBE 는 표의 반환 타입, ALTER TABLE ~ ADD 열 추가 생성
ALTER TABLE project_application
    ADD memo VARCHAR(30);

# 2. 열을 추가한 직후 민수와 지수를 조회합니다. 두 행이 그대로 남아 있고, 두 행의 memo가 모두 NULL인지 확인합니다.
# WHERE 열 이름 IN ('민수', '지수') -> 민수 OR 지수가 있는 열을 대상
SELECT *
FROM project_application
WHERE applicant IN ('민수', '지수');

# 3. team_code가 backend인 팀의 실제 id를 조회합니다. 조회 결과는 정확히 한 행이어야 합니다.
SELECT *
FROM project_team
WHERE team_code = 'backend';

# 4. 3번에서 조회한 실제 팀 번호를 사용하여 다음 신청을 한 건 추가합니다.
# 신청자: 서연, 신청 시각: 2026-11-04 20:00:00, 메모: 노트북 지참
INSERT INTO project_application(team_id, applicant, applied_at, memo)
VALUES (1, '서연', '2026-11-04 20:00:00', '노트북 지참');

# 5. 신청 목록을 다시 조회하여 다음 결과를 확인합니다.
# 민수와 지수의 memo는 NULL입니다.
# 서연의 memo는 노트북 지참입니다.
# 서연.team_id는 3번에서 조회한 backend.id와 같습니다.
SELECT *
FROM project_application
WHERE applicant In ('민수', '지수', '서연');

# 6 현재 팀 수를 before_count로 기록합니다. 이어서 서연.team_id와 같은 id를 가진 project_team 행의 삭제를 시도합니다.
SELECT COUNT(*) AS before_count
FROM project_team;

# 1451 에러 -> Why? 부모 테이블에서 참조중이기 때문에 에러 발생.
DELETE
FROM project_team
WHERE id = 1;

# 7. 삭제 결과로 오류 코드 1451이 발생하는지 확인합니다. 오류가 발생한 g뒤 팀 수를 after_count로 다시 조회합니다.
SELECT COUNT(*) AS after_count
FROM project_team;

# 8. before_count와 after_count가 같고, backend 팀 행이 여전히 남아있는지 확인합니다.
SELECT *
FROM project_team
WHERE team_code in ('backend');

SELECT id, title
FROM post
WHERE title LIKE 'k%';
# % - 0개 이상의 문자, _ - 정확히 한 문자

# id가 3이고, body에 문자 c가 들어갔다면 조회
SELECT *
FROM post
WHERE id = 3
  AND body LIKE '%c%';

INSERT INTO post (member_id, title, body)
VALUES (1, 'exam', 'bring id');
INSERT INTO post (member_id, title, body)
VALUES (1, 'kimbap', 'sold out');
INSERT INTO post (member_id, title, body)
VALUES (1, 'drill', 'one');
INSERT INTO post (member_id, title, body)
VALUES (1, 'drill', 'two');

SELECT *
FROM post
WHERE title LIKE 'd%';

SELECT id, title
FROM post
ORDER BY title DESC
LIMIT 5;

# 2026-10-01 db 실습 예제
# 프로그래머스 MySQL 코딩테스트 문제 - 흉부외과 또는 일반외과 의사 목록 출력하기
# SELECT DR_NAME, DR_ID, MCDP_CD, HIRE_YMD
# FROM DOCTOR
# WHERE MCDP_CD IN('CS', 'GS') 혹은 WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS'
# ORDER BY HIRE_YMD DESC, DR_NAME ASC;

# IS NULL, IS NOT NULL
SELECT *
FROM member
WHERE nickname IS NOT NULL;

INSERT INTO member (login_id)
VALUES ('kdt09');

SELECT *
FROM member
WHERE nickname IS NULL;

# DDL - Data Definition Language, 데이터 정의어 (CREATE, ALTER, DROP, TRUNCATE)
# DML - Data Manipulation Language, 데이터 조작어 (SELECT, INSERT, UPDATE, DELETE)
# DCL - Data Control Language, 데이터 제어어 (GRANT, REVOKE)
# TCL - 트랜잭션 제어어, COMMIT/ROLLBACK

# UPDATE 테이블명 SET 변경문 WHERE 조건문
SELECT id, title, body
FROM post
WHERE title = 'drill';

UPDATE post
SET body = 'kept'
WHERE body = 'one';

SELECT *
FROM post
WHERE title = 'drill';

# 멱등성 - 멱등성(Idempotency)은 연산을 여러 번 수행하든 한 번 수행하든 결과가 똑같이 유지되는 성질.
# create - 경우에 따라 멱등성이 있을 수도 있고, 없을 수도 있음.
# read, delete - 멱등성 있음.
# update - 대부분 멱등적이지만, 멱등성이 없는 경우도 있음.

# JOIN - 두 테이블을 하나의 테이블로 만듦.
# INNER JOIN, LEFT JOIN, RIGHT JOIN, FULL JOIN

SELECT m.login_id, p.title, p.body
FROM member AS m
         INNER JOIN post AS p ON m.id = p.member_id
WHERE p.title = 'closed';


# 집계 함수 - COUNT()
SELECT member_id, COUNT(*) AS post_cnt
FROM post
GROUP BY member_id;

SELECT post.title, COUNT(*) as post_cnt
FROM post
GROUP BY title;

SELECT m.login_id, COUNT(*) AS post_cnt
FROM member AS m
         INNER JOIN post AS p ON m.id = p.member_id
GROUP BY m.login_id;


SELECT *
FROM post
         JOIN cafe;

SELECT post.member_id, COUNT(*)
FROM post
GROUP BY member_id
HAVING COUNT(*) >= 2;

# SQL 순서
# SELECT
# FROM
# WHERE
# GROUP BY
# HAVING
# ORDER BY
# LIMIT
# FROM -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY -> LIMIT 순으로 읽는다.

# 프로그래머스 db 코딩테스트 있었는데요 없었습니다
# SELECT I.ANIMAL_ID, O.NAME
# FROM ANIMAL_INS AS I
# INNER JOIN ANIMAL_OUTS AS O
# ON I.ANIMAL_ID = O.ANIMAL_ID
# WHERE I.DATETIME > O.DATETIME
# ORDER BY I.DATETIME ASC;

# DB 실습 문제
# 일반 RDB에서는 USER라는 예약키워드가 있어서 백틱(`)으로 생성합니다.
CREATE TABLE `USER`
(
    USER_ID   INTEGER     NOT NULL,
    USER_NAME VARCHAR(20) NOT NULL,
    JOIN_DATE DATE        NOT NULL,
    PRIMARY KEY (USER_ID)
);

CREATE TABLE PURCHASE
(
    PURCHASE_ID   INTEGER NOT NULL,
    USER_ID       INTEGER NOT NULL,
    PURCHASE_DATE DATE    NOT NULL,
    PRICE         INTEGER NOT NULL,
    PRIMARY KEY (PURCHASE_ID),
    FOREIGN KEY (USER_ID) REFERENCES USER (USER_ID)
);

-- 1. USER 테이블 데이터 삽입
INSERT INTO `USER` (USER_ID, USER_NAME, JOIN_DATE)
VALUES (1, '홍길동', '2022-01-01'),
       (2, '김철수', '2022-02-15'),
       (3, '이영희', '2022-03-10'),
       (4, '박민수', '2022-04-20'),
       (5, '최지우', '2022-05-05'),
       (6, '강감찬', '2022-06-30');

-- 2. PURCHASE 테이블 데이터 삽입
INSERT INTO PURCHASE (PURCHASE_ID, USER_ID, PURCHASE_DATE, PRICE)
VALUES
-- [유저 1: 홍길동] 2023년 1월에 4번 구매 (조건 통과, 1등 예상)
(101, 1, '2023-01-05', 10000),
(102, 1, '2023-01-10', 20000),
(103, 1, '2023-01-15', 15000),
(104, 1, '2023-01-20', 30000),

-- [유저 2: 김철수] 2023년 1월에 3번 구매 (조건 통과, 2등 예상 - ID가 작음)
(105, 2, '2023-01-02', 5000),
(106, 2, '2023-01-12', 8000),
(107, 2, '2023-01-25', 12000),

-- [유저 3: 이영희] 2023년 1월에 3번 구매 (조건 통과, 3등 예상 - ID가 2보다 큼)
(108, 3, '2023-01-03', 20000),
(109, 3, '2023-01-18', 25000),
(110, 3, '2023-01-28', 30000),

-- [유저 4: 박민수] 2023년 1월에 2번 구매 (HAVING 조건 탈락)
(111, 4, '2023-01-08', 10000),
(112, 4, '2023-01-22', 15000),

-- [유저 5: 최지우] 2023년 2월에 5번 구매 (WHERE 조건 탈락 - 1월이 아님)
(113, 5, '2023-02-01', 5000),
(114, 5, '2023-02-05', 6000),
(115, 5, '2023-02-10', 7000),
(116, 5, '2023-02-15', 8000),
(117, 5, '2023-02-20', 9000),

-- [유저 6: 강감찬] 2023년 1월에 3번, 2월에 2번 구매 (1월 기준 3번이므로 조건 통과, 4등 예상)
(118, 6, '2023-01-04', 10000),
(119, 6, '2023-01-14', 10000),
(120, 6, '2023-01-24', 10000),
(121, 6, '2023-02-04', 10000),
(122, 6, '2023-02-14', 10000);

SELECT U.USER_ID, U.USER_NAME, COUNT(P.PURCHASE_ID) AS PURCHASE_COUNT
FROM USER AS U
         INNER JOIN PURCHASE AS P
                    ON U.USER_ID = P.USER_ID
WHERE P.PURCHASE_DATE >= '2023-01-01'
  AND P.PURCHASE_DATE <= '2023-01-31'
GROUP BY U.USER_ID
HAVING PURCHASE_COUNT >= 3
ORDER BY PURCHASE_COUNT DESC, U.USER_ID
LIMIT 2;

# 프로그래머스 MYSQL 코딩 테스트 문제 - 즐겨찾기가 가장 많은 식당 정보 출력하기
# SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
# FROM REST_INFO
# WHERE (FOOD_TYPE, FAVORITES) IN
#      (   SELECT FOOD_TYPE, MAX(FAVORITES)
#          FROM REST_INFO
#          GROUP BY FOOD_TYPE
#      )
# ORDER BY FOOD_TYPE DESC;

DROP TABLE IF EXISTS tray;
DROP TABLE IF EXISTS jdbc_post;
DROP TABLE IF EXISTS jdbc_member;

CREATE TABLE jdbc_member
(
    id       INT         NOT NULL AUTO_INCREMENT,
    login_id VARCHAR(20) NOT NULL,
    nickname VARCHAR(20),
    PRIMARY KEY (id),
    UNIQUE (login_id)
) ENGINE = INNODB;

CREATE TABLE jdbc_post
(
    id        INT         NOT NULL AUTO_INCREMENT,
    member_id INT         NOT NULL,
    title     VARCHAR(40) NOT NULL,
    body      VARCHAR(200),
    PRIMARY KEY (id),
    INDEX idx_jdbc_member_id (member_id),
    FOREIGN KEY (member_id) REFERENCES jdbc_member (id)
) ENGINE = INNODB;

INSERT INTO jdbc_member (login_id, nickname)
VALUES ('jdbc01', 'kim'),
       ('jdbc02', 'lee');

INSERT INTO jdbc_post (member_id, title, body)
VALUES (1, 'closed', 'no class'),
       (1, 'kimbap', 'sold out'),
       (2, 'opened', 'done');

SELECT id, login_id, nickname
FROM jdbc_member
ORDER BY id;

SELECT id, member_id, title, body
FROM jdbc_post
ORDER BY id;