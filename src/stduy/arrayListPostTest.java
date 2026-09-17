package stduy;

import java.util.ArrayList;

public class arrayListPostTest {

    public static void main(String[] args) {

        // arraylist 만드는데, 타입은 Post 만 받을 수 있다. 그리고 새 Post 객체 3개를 만들어서 해당 arrayList 에 추가한다.
        // 반복문으로 그 3가지 각 객체에 존재하는 필드 2가지를 출력한다.
        ArrayList<Post> arrayList = new ArrayList<>();

        Post post1 = new Post();
        Post post2 = new Post();
        Post post3 = new Post();

        post1.title = "post1";
        post1.body = "body1";
        post2.title = "post2";
        post2.body = "body2";
        post3.title = "post3";
        post3.body = "body3";

        arrayList.add(post1);
        arrayList.add(post2);
        arrayList.add(post3);

        // 인덱스를 통한 접근
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("post" + (i+1) + ".title = " + arrayList.get(i).title);
            System.out.println("post" + (i+1) + ".body = " + arrayList.get(i).body);
        }

        System.out.println();

        // 각 객체를 통한 접근 (향상된 for문)
        for (Post p : arrayList) {
            System.out.println("title = " + p.title);
            System.out.println("body = " + p.body);

        }
    }

}
