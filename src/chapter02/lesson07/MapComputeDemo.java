package chapter02.lesson07;

import java.util.HashMap;
import java.util.Map;

public class MapComputeDemo {

    public static void main(String[] args) {
        Map<String, Integer> count = new HashMap<>();
        for (String tag : new String[]{"메모", "퀴즈", "메모"}) {
            count.compute(tag, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
            System.out.println("메모 = " + count.get("메모")); // 1 -> 1 -> 2
            System.out.println("퀴즈 = " + count.get("퀴즈")); // 0 -> 1 -> 1
        }
    }


}
