package Algorithms.Baekjoon.Class1;

import java.util.Scanner;

public class BOJ2577_NumberOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        long result = a * b * c;
        String str = String.valueOf(result);
        for(int i=0; i<10; i++) {
            int sum = 0;
            for(int j=0; j<str.length(); j++) {
                if(str.charAt(j) - '0' == i) {
                    sum += 1;
                }
            }
            System.out.println(sum);
        }
    }
}
