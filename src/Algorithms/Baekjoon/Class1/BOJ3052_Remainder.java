package Algorithms.Baekjoon.Class1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ3052_Remainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i=0; i<10; i++) {
            arr[i] = sc.nextInt() % 42;
        }
        Arrays.sort(arr);
        int result = 0;
        int curr = -1;
        for(int i=0; i<10; i++) {
            if(arr[i] != curr) {
                result++;
                curr = arr[i];
            }
        }
        System.out.println(result);
    }
}
