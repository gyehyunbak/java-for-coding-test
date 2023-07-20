package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003_Fibonacci {
    static int one, zero;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            zero = 1;
            one = 0;
            int n = Integer.parseInt(br.readLine());
            //long start = System.currentTimeMillis(); // 코드 실행시간 테스트용
            fibonacci2(n);
            //long end = System.currentTimeMillis(); // 코드 실행시간 테스트용
            System.out.println(zero + " " + one);
            //System.out.println("실행시간 : " + (end - start) + " ms"); // 코드 실행시간 테스트용
        }
    }

    static int fibonacci(int n) {
        // 40에서 335ms
        if(n == 0) {
            zero++;
            return 0;
        } else if(n == 1) {
            one++;
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    static void fibonacci2(int n) {
        // 40에서 0ms..?
        if(n==0) {
        }
        else if(n==1) {
            zero = 0;
            one = 1;
        }
        else {
            zero = 0;
            one = 1;
            while(n-- > 1) {
                int tmp = zero + one;
                zero = one;
                one = tmp;
            }
        }
    }
}
