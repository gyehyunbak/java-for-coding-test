package ThisIsJava.ch05.sec05;

public class IndexOfCcontainsExample {
    public static void main(String[] args) {
        String subject = "자바 프로그래밍";

        int location = subject.indexOf("프로그래밍");
        System.out.println(location);
        String substing = subject.substring(location);
        System.out.println(substing);

        location = subject.indexOf("자바");
        if(location != 1) {
            System.out.println("자바와 관련된 책이군요");
        } else {
            System.out.println("자바와 관련 없는 책이군요");
        }
    }
}
