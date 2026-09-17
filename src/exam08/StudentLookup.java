/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-17
 * 08 - ArrayList HashMap
 * 실습 문제 1
 */
package exam08;

import java.util.HashMap;

public class StudentLookup {

    public static void main(String[] args) {

        HashMap<Object, Object> students = new HashMap<>();

/*
        // 1단계
        students.put("2024001", "김민");
        students.put("2024002", "이준");

        System.out.println(students.get("2024001"));
        System.out.println(students.get("2024002"));
        System.out.println(students.get("2024999"));
*/

        // 2단계
        students.put("2024001", "김민");
        students.put("2024001", "김민수");

        System.out.println(students.get("2024001"));
        System.out.println(students.size());

        students.put("2024002", "이준");

        System.out.println(students.size());

        System.out.println();

        // 3단계
        if (students.containsKey("2024001")) System.out.println(students.get("2024001"));
        else System.out.println("missing");

        if (students.containsKey("2024999")) System.out.println(students.get("2024999"));
        else System.out.println("missing");

        System.out.println();

        // 4단계
        for (Object o : students.keySet()) {
            System.out.println(o);
            System.out.println(students.get(o));
        }

        System.out.println();

        // 5단계
        students.put("2024003", "박소라");
        students.put("2024001", "김민");

        System.out.println(students.get("2024001"));
        System.out.println(students.get("2024003"));
        System.out.println(students.size());

        System.out.println();

        // 6단계
        String[] ids = {"2024004", "2024005", "2024004"};
        String[] names = {"최윤", "정하", "최윤서"};

        for (int i = 0; i < ids.length; i++) {
            students.put(ids[i], names[i]);
            System.out.println(students.get(ids[i]));
        }

    }

}
