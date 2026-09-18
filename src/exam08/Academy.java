/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-18
 * 08 - ArrayList HashMap
 * CRUD 실습 예제
 */
package exam08;

import java.util.ArrayList;
import java.util.HashMap;

// 학생 정보를 담는 Class (ArrayList 와 HashMap 의 차이)
public class Academy {

    ArrayList<Student> list = new ArrayList<>();
    HashMap<Integer, Student> map = new HashMap<>();

    public static void main(String[] args) {
        Academy academy = new Academy();

        // 1. 학생 4명 등록
        academy.addStudent(1, "홍길동", "Java", 90);
        academy.addStudent(2, "김철수", "Java", 85);
        academy.addStudent(3, "이영희", "Python", 95);
        academy.addStudent(4, "박민수", "Java", 70);

        // 2. 전체 조회
        System.out.println("\n--- 전체 조회 ---");
        academy.printAll();

        // 3. 2번 점수 수정 후 전체 조회
        System.out.println("\n--- 2번 점수 100으로 수정 ---");
        academy.updateScore(2, 100);
        academy.printAll();

        // 4. 1번 삭제 후 전체 조회
        System.out.println("\n--- 1번 삭제 ---");
        academy.deleteStudent(1);
        academy.printAll();

        // 5. 3번 단건 조회
        System.out.println("\n--- 3번 단건 조회 ---");
        academy.printOne(3);

        // 6. 과목별 조회 (없는 과목 포함)
        System.out.println("\n--- 과목별 조회 ---");
        academy.printBySubject("Java");
        academy.printBySubject("Python");
        academy.printBySubject("C++"); // 존재하지 않는 과목
    }

    // Create
    public void addStudent(int no, String name, String subject, int score) {
        Student student = new Student();

        student.setInfo(no, name, subject, score);

        list.add(student);
        map.put(student.no, student);

        System.out.println("등록 완료 = " + name);

    }

    // Read(ArrayList) list 를 순서대로 돌며, 전체 학생 출력
    public void printAll() {
        for (Student student : list) {
            student.printInfo();
        }
    }

    // Read(HashMap) map 에서 key 값으로 바로 찾아 value 출력
    public void printOne(int no) {
        if (map.containsKey(no)) {
            map.get(no).printInfo();
        } else System.out.println("없는 번호: {" + no + "}");

        /*
        강사님 코드
        Student s = map.get(no);
        if (s == null) {
            System.out.println("없는 번호: " + no);
            return;
        }
        s.printInfo();
         */
    }

    // Update
    public void updateScore(int no, int newScore) {
        if (map.containsKey(no)) {
            if ((newScore < 0) || (newScore > 100)) System.out.println("newScore 가 0 ~ 100 범위를 벗어남");
            else map.get(no).score = newScore;
        } else System.out.println("없는 번호");

        /*
        강사님 코드
        Student s = map.get(no);

        if (s == null) {
            System.out.println("없는 번호: " + no);
            return; // return; 쓰지 않으면, 점수 업데이트 반영됨.
        }
        if (newScore < 0 || newScore > 100) {
            System.out.println("점수는 0 ~ 100 사이여야 합니다. "+ newScore);
            return; // return; 쓰지 않으면, 코드가 아래로 계속 내려감.
        }
        s.score = newScore; // Update 단, 필드 직접 접근이라 좋지 않은 케이스. setScore 로 접근해야함.
        */
    }

    // Delete
    public void deleteStudent(int no) {
        Student s = map.remove(no); // remove 를 해도 heap 영역에서 삭제 되지는 않음. 참조만 끊어진 것

        if (s == null) {
            System.out.println("없는 번호: " + no);
            return;
        }

        list.remove(s); // map.remove 는 map 에서만 참조가 끊어진 것이므로, list 도 참조를 끊어줘야함
    }

    // 과목별 학생 찾기
    public ArrayList<Student> findAllBySubject(String subject) {
        ArrayList<Student> result = new ArrayList<>();

        for (Student s : list) {
            if (s.subject.equals(subject)) {
                result.add(s);
            }
        }

        return result;
    }

    // 과목별 학생 출력하기
    public void printBySubject(String subject) {
        ArrayList<Student> result = findAllBySubject(subject);
        if (findAllBySubject(subject).isEmpty()) {
            System.out.println("해당 과목 수강생이 없습니다.");
        } else {
            for (Student s : result) {
                s.printInfo();
            }
        }

        /*
        강사님 코드
        ArrayList<Student> result = findAllBySubject(subject);

        if (result.isEmpty()) {
            System.out.println("해당 과목 수강생이 없습니다: " + subject);
            return; // else 가 없는 경우에 if 가 참이어서 코드를 종료하고 싶을땐, return; 을 사용한다.
        }

        System.out.println("== " + subject + " 수강생 ==");
        for (Student s : result) {
            s.printInfo();
        }
        */
    }

}
