package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11050_BinomialCoefficient {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int bc = factorial(n) / (factorial(r) * factorial(n-r));
        System.out.println(bc);
    }

    public static int factorial(int a) {
        int result = 1;
        for(int i=a; i>0; i--) {
            result = result * i;
        }
        return result;
    }
}
