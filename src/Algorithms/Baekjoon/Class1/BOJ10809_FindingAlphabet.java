package Algorithms.Baekjoon.Class1;

import java.util.Scanner;

public class BOJ10809_FindingAlphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = new int[26];
        for(int i=0; i<26; i++) {
            char ch = (char) ('a' + i);
            arr[i] = str.indexOf(ch);
        }
        for(int i=0; i<26; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
