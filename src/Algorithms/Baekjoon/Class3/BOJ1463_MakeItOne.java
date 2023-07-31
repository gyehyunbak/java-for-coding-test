package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463_MakeItOne {

    static Integer[] dp; // 메모이제이션 배열, Integer[] 배열은 기본값이 0이 아닌 null이다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 배열 초기화
        dp = new Integer[n + 1];
        dp[0] = dp[1] = 0;

        System.out.println(DP(n));
    }

    static int DP(int n) {

        // 업데이트 되지 않는 값에 대해 연산 수행
        if(dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(DP(n - 1), Math.min(DP(n / 3), DP(n / 2))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(DP(n / 3), DP(n - 1)) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(DP(n / 2), DP(n - 1)) + 1;
            } else {
                dp[n] = DP(n - 1) + 1;
            }
        }
        return dp[n];
    }
}
