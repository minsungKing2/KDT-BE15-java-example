package stduy;

// 설계도(틀)
public class Post {
    String title; // 제목
    String body; // 본문

    public void print() {
        System.out.println("title = " + title);
        System.out.println("body = " + body);
        // void 는 반환 활 타입이 없어서 return 문을 쓰지 않아도 됨.
    }

    public String showTitle() {
        // 반환할 타입이 String 이라서 return 문을 반드시 써야하고, 그 뒤에 값에는 타입이 맞아야 한다.
        return "okay";
    }

    // 함수 이름은 plusTitle 이고, 반환 값은 문자열이다.
    // 반환할 값은 title 필드 값에 있는
    public String plusTitle() {
        return title + "1";
    }

    // 함수 이름은 isBody 이고, 반환 타입은 boolean, 반환활 값은 만약에 body  값이 null 이라면 true 를 반환하고,
    // 아니면 false 를 반환
    public boolean isBody() {
        return body == null; // boolean 기본 값은 false, int 기본 값은 0, String 기본 값은 null
    }

    // argument(인자) 를 받는 메서드
    public void printArg(String arg) { // 문자열 타입의 한 개의 인자를 받고, 본문에서 출력한다.
        System.out.println("arg = " + arg);
    }

    // argument(String arg) 를 받는 메서드 addBody 만들고,반환 타입은 없다.
    // 메서드 결과는 화면에 body + 넘겨받은 arg 를 더해서 출력한다.
    public void addBody(String arg) {
        System.out.println(body + arg);
    }

    // 인자를 반드시 2개 전부 넣어야 함.
    public void addTitle(String arg, String arg2) {
        System.out.println(title + arg + arg2);
    }

    // 함수명이 똑같아도 인자에 있는 타입들이 다르면 정상적으로 실행이 된다.
    public void addTitle(String arg, int arg2) {
        System.out.println(title + arg + arg2);
    }

    public void test(String arg, int... ints) {
    }
    // 가변 인자 위치는 항상 뒤에
    // public void test1(String... arg2, String arg1) {
    //
    //} -> 이 경우에는 가변 인자가 앞이라서 불가능

    // Object 는 최상위 타입
    public void test2(Object... arg) {

    }

}
