package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047_Coin0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coins = new int[n];
        int cnt = 0;

        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i = coins.length-1; i>=0; i--) {
            if(k/coins[i] >= 1) {
                cnt += k / coins[i];
                k = k % coins[i];
            }
        }

        System.out.println(cnt);
    }
}
