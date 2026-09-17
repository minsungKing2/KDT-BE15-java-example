/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-17
 * 08 - ArrayList HashMap
 * 실습 문제 2
 */
package exam08;

import java.util.ArrayList;

public class MemberDemo {

    public static void main(String[] args) {

        ArrayList<Member> list = new ArrayList<>();

        Member member = new Member();
        
        member.id = "id1";
        member.name = "Kim";
        member.age = 20;

        list.add(member);

        for (Member m : list) {
            System.out.println("meber.id = " + m.id);
            System.out.println("meber.name = " + m.name);
            System.out.println("meber.age = " + m.age);
        }

        member.isNameKim();

    }

}
