package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11727 {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1];
        System.out.println(DP(n));
    }

    public static long DP(int n) {
        if(n == 1) return 1;
        if(n == 2) return 3;
        if(dp[n] == 0) {
            dp[n] = (DP(n-1) + 2 * DP(n-2)) % 10007;
        }
        return dp[n];
    }
}
