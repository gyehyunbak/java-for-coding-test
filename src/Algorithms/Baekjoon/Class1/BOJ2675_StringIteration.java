package Algorithms.Baekjoon.Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2675_StringIteration {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int k=0; k<t; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());

            String str = st.nextToken();
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < r; j++) {
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();
        }
    }
}
