package ThisIsJava.ch05.sec05;

public class SubStringExample {
    public static void main(String[] args) {
        String ssn = "880815-1234567";

        String firstNUm = ssn.substring(0,6);
        System.out.println(firstNUm);

        String SecondNum = ssn.substring(7);
        System.out.println(SecondNum);
    }
}
