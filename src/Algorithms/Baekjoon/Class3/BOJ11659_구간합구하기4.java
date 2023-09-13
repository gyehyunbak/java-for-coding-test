package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659_구간합구하기4 {
    // 단순히 입력 받은 배열을 반복 접근해서 sum 값을 구했더니 시간초과가 떴다
    // 미리 모든 누적합을 구해놓고 누적합이 이전의 값들을 포함하고 있음을 이용해
    // 포함되지 않는 앞부분을 빼는 방식으로 풀었다 (단, 맨 앞에 0이 필요하다)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken());
            int sum = arr[end] - arr[start];

            System.out.println(sum);
        }
    }
}
