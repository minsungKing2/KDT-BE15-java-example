/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-18
 * 08 - ArrayList HashMap
 * CRUD 실습 예제
 */
package exam08;

// 학생 정보 관리 Class
public class Student {

    int no; // 학생 번호
    String name; // 이름
    String subject; // 수강 과목
    int score; // 점수

    // setter
    public void setInfo(int pNo, String pName, String pSubject, int pScore) {
        this.no = pNo;
        this.name = pName;
        this.subject = pSubject;
        this.score = pScore;

       /*
        no = pNo;
        name = pName;
        subject = pSubject;
        score = pScore;
        */
    }

    public void printInfo() {
        System.out.print("번호 : " + no + " ");
        System.out.print("이름 : " + name + " ");
        System.out.print("과목 : " + subject + " ");
        System.out.print("점수 : " + score + " ");
        System.out.println();
    }

}
