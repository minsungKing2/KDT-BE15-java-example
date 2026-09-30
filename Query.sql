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

ALTER TABLE desk ADD opened_at DATETIME;

INSERT INTO desk (item, desk.opened_at)
VALUES ('lunch', '2026-09-30 10:45:00');

SELECT * FROM desk;

# 3. 과제 - 1
USE kdt;

CREATE TABLE project_team
(
    id Int NOT NULL AUTO_INCREMENT,
    team_code VARCHAR(20) NOT NULL,
    team_name VARCHAR(30) NOT NULL,
    opened_at DATETIME,
    PRIMARY KEY (id),
    UNIQUE (team_code)
);

CREATE TABLE project_application
(
    id INT AUTO_INCREMENT NOT NULL,
    team_id INT NOT NULL,
    applicant VARCHAR(20) NOT NULL,
    applied_at DATETIME,
    PRIMARY KEY (id),
    FOREIGN KEY (team_id) REFERENCES project_team(id)
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

SELECT * FROM project_application;

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
DELETE FROM project_team
WHERE id = 1;

# 7. 삭제 결과로 오류 코드 1451이 발생하는지 확인합니다. 오류가 발생한 뒤 팀 수를 after_count로 다시 조회합니다.
SELECT COUNT(*) AS after_count
FROM project_team;

# 8. before_count와 after_count가 같고, backend 팀 행이 여전히 남아있는지 확인합니다.
SELECT *
FROM project_team
WHERE team_code in ('backend');