package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 다이나믹 프로그래밍과 재귀함수를 이용해 풀었다. (파도반 수열과 비슷했다)
// 다이나믹 프로그래밍의 목적은 중복 연산을 피하는 것이며 핵심 접근 방식은 점화식을 찾는 것이다.
public class BOJ11726 {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1];
        System.out.println(DP(n));
    }

    // mod 연산을 한 결과값을 출력해야 할 때에는 반드시 연산할 때마다 mod 연산을 해주어야 한다.
    // 계속 숫자를 더하고 마지막 출력시에만 mod연산을 해줄 경우 Integer.MAX_VALUE를 넘어 Overflow가 발생하기 때문에 잘못된 값이 출력될 수 있다.
    public static long DP(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(dp[n] == 0) {
            dp[n] = (DP(n-1) + DP(n-2)) % 10007;
        }
        return dp[n];
    }
}
