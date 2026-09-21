/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-21
 * 2-07b-스트림-심화 예외 처리
 * 과제 2-1. RoomReservation
 */
package exam2_07;

import java.io.IOException;

public class RoomReservation {
    public static void main(String[] args) {
        RoomReservation app = new RoomReservation();

        try {
            app.reserve("kim", "");
        } catch (IllegalArgumentException | NullPointerException ex) {
            // 복수 예외처리는 예외객체 | 예외객체 변수명 -> IllegalArgumentException(명확한? 구체적? 예외라고 함)
            System.out.println("reject = " + ex.getMessage());
        }

        app.reserve("kim", "b201");

    }

    public void reserve(String name, String room) {
        if (name == null || name.equals("")) {
            // name.isEmpty() 도 가능
            throw new IllegalArgumentException("empty-name");
        }

        if (room == null || room.equals("")) {
            throw new IllegalArgumentException("empty-room");
        }

        System.out.println("reversed = " + name + ", " + room);

    }
}
