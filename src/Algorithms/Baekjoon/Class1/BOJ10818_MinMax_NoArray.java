package Algorithms.Baekjoon.Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10818_MinMax_NoArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int max = -1000001;
        int min = 1000001;

        while(st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());

            if(tmp>max) {
                max = tmp;
            }
            if(tmp<min) {
                min = tmp;
            }
        }

        System.out.println(min + " " + max);
    }
}
