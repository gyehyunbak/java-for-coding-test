package Algorithms.Baekjoon.Class1;

import java.util.Scanner;

public class BOJ2908_SangSoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strA = reverse(sc.next());
        String strB = reverse(sc.next());
        int a = Integer.parseInt(strA);
        int b = Integer.parseInt(strB);
        System.out.println(Math.max(a, b));
    }

    public static String reverse(String str) {
        String result = "";
        for(int i=str.length()-1; i>=0; i--) {
            result = result + str.charAt(i);
        }
        return result;
    }
}
