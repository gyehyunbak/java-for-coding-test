package Algorithms.Baekjoon.Class2;

import java.util.Scanner;

public class BOJ2231_DisintegrationSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = Integer.parseInt(str);
        int len = str.length();
        int result = 0;

        // 가능한 각 자리수 조합: 111(3)~999(27)

        for(int i=(n-(len * 9)); i<n; i++) {
            int num = i;
            int sum = 0;
            while(num != 0) {
                sum += num % 10;
                num /= 10;
            }
            if(sum + i == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
