package Algorithms.Baekjoon.Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8958_OX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {

            String str = br.readLine();
            int streak = 0;
            int score = 0;

            for(int j=0; j<str.length(); j++) {
                if (str.charAt(j) == 'O') {
                    streak++;
                    score += streak;
                } else {
                    streak = 0;
                }
            }

            System.out.println(score);
        }
    }
}
