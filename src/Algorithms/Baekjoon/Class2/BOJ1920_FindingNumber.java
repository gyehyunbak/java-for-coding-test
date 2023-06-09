package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920_FindingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] arrA = new int[n];

        for(int i=0; i<n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);

        for(int i=0; i<m; i++) {
            if(Arrays.binarySearch(arrA, Integer.parseInt(st2.nextToken())) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
