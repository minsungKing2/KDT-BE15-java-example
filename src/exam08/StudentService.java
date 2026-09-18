/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-18
 * 08 - ArrayList HashMap
 * Service(CRUD)
 */
package exam08;

import java.util.ArrayList;

public class StudentService {

    StudentRepository repository = new StudentRepository();

    // 추가 Create
    public void join(int no, String name, String subject, int score) {
        if (repository.findByNo(no) != null) {
            System.out.println("이미 존재하는 번호: " + no);
            return;
        }

        Student student = new Student();
        student.setInfo(no, name, subject, score);
        repository.save(student);

        System.out.println("등록 완료: " + name);
    }

    // 조회 Read
    // 전체 조회
    public void printAll() {
        for (Student s : repository.findAll()) {
            s.printInfo();
        }
    }

    // 단건 조회
    public void printOne(int no) {
        Student s = repository.findByNo(no);
        if (s == null) {
            System.out.println("없는 번호: " + no);
            return;
        }
        s.printInfo();
    }

    // 수정 Update
    public void changeScore(int no, int newScore) {

        // 검증 1: 존재하는 학생인가?
        Student s = repository.findByNo(no);
        if (s == null) {
            System.out.println("없는 번호: " + no);
            return;
        }

        // 검증 2: 점수 범위가 유요한가?
        if (newScore < 0 || newScore > 100) {
            System.out.println("점수 범위 0 ~ 100: " + newScore);
            return;
        }

        repository.updateScore(s, newScore);
        System.out.println("수정 완료: " + newScore);

    }

    // 삭제 Delete
    public void remove(int no) {
        Student s = repository.findByNo(no);
        // 존재 여부 확인
        if (s == null) {
            System.out.println("없는 번호: " + no);
            return;
        }
        repository.delete(no);
        System.out.println("삭제 완료: " + no);
    }

    // 과목별 출력
    public void printBySubject(String subject) {
        ArrayList<Student> result = repository.findAllBySubject(subject);
        for (Student student : result) {
            if (student.subject == null) {
                System.out.println("해당 과목 수강생이 없습니다. " + student);
                return;
            }
            student.printInfo();
        }

        /*
        강사님 코드
        if (result.isEmpty()) {
            System.out.println("해당 과목 수강생이 없습니다. " + subject);
            return;
        }

        System.out.println("==" + subject + "수강생 ==");

        for (Student s : result) {
            s.printInfo();
        }
        */
    }

}
