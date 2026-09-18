/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-18
 * 08 - ArrayList HashMap
 * Repository(CRUD)
 */
package exam08;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentRepository {

    ArrayList<Student> list = new ArrayList<>();
    HashMap<Integer, Student> map = new HashMap<>();

    // Create
    public void save(Student student) {
//        student.setInfo(student.no, student.name, student.subject, student.score);
        list.add(student);
        map.put(student.no, student);
    }

    public ArrayList<Student> findAll() {
        return list;
    }

    public Student findByNo(int no) {
        return map.get(no);
    }

    // 점수 변경 Update
    public void updateScore(Student s, int newScore) {
        s.score = newScore;
    }

    // 삭제 Delete
    public void delete(int no) {
        Student s = map.remove(no);
        if (s != null) {
            list.remove(s);
        }
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



}
