package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609_GCD_LCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmp1 = Integer.parseInt(st.nextToken());
        int tmp2 = Integer.parseInt(st.nextToken());
        int a = Math.max(tmp1, tmp2);
        int b = Math.min(tmp1, tmp2);
        int r = a % b;

        System.out.println(gcd_iteration(a, b));
        System.out.println(lcm(a, b));
    }

    // 반복법으로 구현한 gcd
    public static int gcd_iteration(int a, int b) {
        while(b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }

        return a;
    }

    // 재귀로 구현한 gcd
    public static int gcd_recurrence(int a, int b) {
        if(b == 0) return a;
        return gcd_recurrence(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd_recurrence(a, b);
    }
}
