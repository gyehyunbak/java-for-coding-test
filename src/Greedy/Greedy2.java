package Greedy;

import java.util.*;
public class Greedy2 {
    public static void main(String[] args) {
        // 입력 파트
        Scanner sc = new Scanner(System.in);

        // N, M, K 입력. 공백 기준
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // N개의 자연수 입력. 공백 기준
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //----------------------------------------------------
        // 알고리즘 파트
        Arrays.sort(arr); // 입력받은 수를 비내림차순 정렬
        int x = arr[n-1];
        int y = arr[n-2]; // 정렬된 배열에서 가장 큰 두 수만 필요하다

        // 가장 큰 수가 더해진 횟수
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1);

        // cnt를 통해 최종 덧셈 결과 구하기
        int result = x * cnt;
        result += y * (m - cnt);

        System.out.println(result);
    }
}