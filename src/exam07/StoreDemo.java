/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-17
 * 07-클래스와 메모리
 * 실습 추가 문제 1
 */
package exam07;

public class StoreDemo {

    public static void main(String[] args) {

        Item item1 = new Item();
        item1.name = "삼각 김밥";
        item1.price = 1500;
        item1.stock = 10;
        item1.isEvent = true;

        Item item2 = new Item();
        item2.name = "콜라";
        item2.price = 2000;
        item2.stock = 5;
        item2.isEvent = false;


        Item item3 = new Item();
        item3.name = "라면";
        item3.price = 1200;
        item3.stock = 20;
        item3.isEvent = true;

        Item item4 = new Item();
        item4.name = "초코바";
        item4.price = 800;
        item4.stock = 0;
        item4.isEvent = false;

        Store store = new Store();
        store.name = "GS25";
        store.location = "서울시 강남구";
        store.isOpen = true;

        store.items = new Item[4];

        store.items[0] = item1;
        store.items[1] = item2;
        store.items[2] = item3;
        store.items[3] = item4;

        System.out.println("===== 편의점 정보 =====");
        System.out.println("편의점명: " + store.name);
        System.out.println("영업 중: " + store.isOpen);
        System.out.println("총 상품 수: " + store.items.length);
        System.out.println();

        System.out.println("----- 상품 목록 -----");
        for (int i = 0; i < store.items.length; i++) {

            Item item = store.items[i];


        }
    }

}
