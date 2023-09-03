package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461_파도반수열 {
    // P(n) = P(n-1) + P(n-5)
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            dp = new long[n + 1];
            System.out.println(DP(n));
        }
    }

    // DP를 통한 풀이 -> (틀림) n이 커지면 오버플로 발생 -> long 으로 변환
    public static long DP(int n) {
        if(n < 4) {
            return 1;
        } else if (n < 6) {
            return 2;
        } else {
            if (dp[n] == 0) {
                dp[n] = DP(n - 1) + DP(n - 5);
            }

            return dp[n];
        }
    }

    // 시간 초과 -> DP를 통해 중복 계산 방지
    public static int P(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return 1;
        } else if (n == 4 || n == 5) {
            return 2;
        } else {
            return P(n - 1) + P(n - 5);
        }
    }
}
