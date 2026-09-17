package stduy;

import java.util.HashMap;

public class MapTest {

    public static void main(String[] args) {

        // Map 은 Key 와 Value 의 쌍으로 이루어져 있다.
        HashMap<String, String> orders = new HashMap<>();

        // Map 의 put 은 ArrayList 의 add 와 같은 개념 ( + put 은 ArrayList 의 update 의 기능도 함)
        orders.put("mina", "americano");
        orders.put("jun", "kimbap");

        System.out.println("orders = " + orders.get("mina"));

        // Create 와 Update 의 형태를 띄고 있다. (put)
        orders.put("mina", "kimbap");
        // Update 의 형태를 띄고 있다. (replace)
        orders.replace("jun", "americano");

        // 조건부 수정  해당하는 Key 값을 가진 친구의 현재 값(oldValue)이랑 비교해서 같다면, new Value 로 바꿈.
        orders.replace("mina", "kimbap", "american");

        // Key 값을 내가 검색해서 실제 Map 에 Key 가 있는지 검사 -> containsKey(키 값)
        if (orders.containsKey("zz")) System.out.println("orders = " + orders.get("mina"));
        else System.out.println("missing");

        System.out.println();

        // Key 값만 순차적으로 반환 -> orders.keySet() 은 orders 의 key 값을 가져와서 Set(세트) 덩어리로 만들어 줌 set() 의 개념이 아님
        for (String name : orders.keySet()) {
            System.out.println(name);
            System.out.println(orders.get(name));
        }

        System.out.println();

        // Value 값만 순차적을 반환.
        for (String value : orders.values()) {
            System.out.println(value);
        }

        // JDK( JRE ( JVM ) )

    }

}
