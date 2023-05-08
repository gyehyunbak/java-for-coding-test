package Algorithms.Baekjoon.Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BOJ10818_MinMax {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] intArr = new int[n];
        for(int i=0; i<n; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(intArr);
        System.out.println(intArr[0] + " " + intArr[n-1]);
    }
}
