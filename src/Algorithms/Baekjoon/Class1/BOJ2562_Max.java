package Algorithms.Baekjoon.Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2562_Max {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1;
        int index = -1;
        for(int i = 0; i < 9; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(max < tmp) {
                max = tmp;
                index = i + 1;
            }
        }
        System.out.println(max + "\n" + index);
    }
}
