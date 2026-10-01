package coding_test_exam;

public class MySqlExam {

    public static void main(String[] args) {

        System.out.println("프로그래머스 코딩 테스트 MYSQL 문제");
        /*
        프로그래머스 코딩 테스트 MYSQL LEVEL 3 - 헤비 유저가 소유한 장소
        SELECT ID, NAME, HOST_ID
        FROM PLACES
        WHERE HOST_ID IN
        (
        SELECT HOST_ID
        FROM PLACES
        GROUP BY HOST_ID
        HAVING COUNT(HOST_ID) >= 2
        )
        ORDER BY ID ASC;
         */

    }

}
