package Algorithms.Baekjoon.Class1;

import java.util.Scanner;

public class BOJ10871_SmallerThanX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            if(num < x) {
                System.out.print(num + " ");
            }
        }
    }
}