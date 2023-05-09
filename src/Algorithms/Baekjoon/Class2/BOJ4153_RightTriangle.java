package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ4153_RightTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[3];
        while(true) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            if(arr[0] == 0 || arr[1] == 0 || arr[2] == 0) break;

            if(arr[2]*arr[2] == arr[0]*arr[0] + arr[1]*arr[1]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }

    }
}
