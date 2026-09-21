/*
 * 프로그래머스 데브코스 KDT [BE15]
 * 26-09-21
 * 2-03b-OOP-도메인-메서드
 * 과제 2 - 고정 글 PinnedPost
 */
package chapter02.lesson03;

public class PinnedPost extends Post {

    private boolean pinned;

    public PinnedPost(String title, String body) {
        super(title, body);
        this.pinned = false;
    }

    public void pin() {
        this.pinned = true;
    }

    public boolean isPinned() {
        return this.pinned;
    }

    @Override
    public void changeTitle(String next) {
        if (this.pinned) {
            System.out.println("reject = pinned");
            return;
        }
        super.changeTitle(next);
    }

    @Override
    public void print() {
        System.out.println("pinned = " + this.pinned);
        super.print();
    }
}
