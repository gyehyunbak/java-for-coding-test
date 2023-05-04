package Algorithms.ThisIsCodingTest.Greedy;

import java.util.*;

public class Greedy3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int min_value = 10001;
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                // min_value와 해당 행의 각 원소를 비교, 작은 값 선택
                min_value = Math.min(min_value, x);
            }
            // 다른 열에서 가장 작은 원소와 해당 열에서 가장 작은 원소 중 큰 값 선택
            result = Math.max(result, min_value);
        }

        System.out.println(result);
    }
}

// 입력
// 3 3
// 3 1 2
// 4 1 4
// 2 2 2
//
// 출력
// 2