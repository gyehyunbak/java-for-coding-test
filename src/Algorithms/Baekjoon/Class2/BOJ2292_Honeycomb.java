package Algorithms.Baekjoon.Class2;

import java.util.Scanner;

public class BOJ2292_Honeycomb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int cnt = 1;
        long i = 1;
        while(i < n) {
            i += (long) cnt++ * 6;
        }
        System.out.println(cnt);
    }
}
