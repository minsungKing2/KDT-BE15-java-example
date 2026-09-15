/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-15
 * 02-변수와 출력
 * 실습 4
 */
package exam02;

public class IntTop {

    public static void main(String[] args) {

        int top = Integer.MAX_VALUE;
        int wrap = top + 1;

        System.out.println("top = " + top);
        System.out.println("wrap = " + wrap);

        //top 과 wrap 이 다름. wrap 에 오버플로우 발생하여 int형 범위에서 가장 작은 수가 출력됨.
    }
}
