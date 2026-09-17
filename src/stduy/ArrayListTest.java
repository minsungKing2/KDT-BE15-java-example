package stduy;

import java.util.ArrayList;

public class ArrayListTest {

    public static void main(String[] args) {

        ArrayList<String> titles = new ArrayList<>();

        titles.add("closed");
        titles.add("exam");
        titles.add("holiday"); // create

        System.out.println("titles = " + titles);
        System.out.println("titles.size = " + titles.size());
        System.out.println("titles.get = " + titles.get(2)); // read
//        System.out.println("titles.get = " + titles.get(3)); 범위 초과
        System.out.println("titles.get = " + titles.getClass());

        titles.set(1, "make up"); // 1번째 인덱스에 있는 값을 makeup 으로 바꿔라. (update)
        titles.remove(2); // 2번째 인덱스에 있는 값을 ArrayList 에서 삭제 (delete)

        ArrayList<String> titles2 = new ArrayList<>();

        System.out.println("titles2 = " + titles2);
//        System.out.println("titles2 = " + titles2.getFirst()); 요소 없음 에러
    }

}
