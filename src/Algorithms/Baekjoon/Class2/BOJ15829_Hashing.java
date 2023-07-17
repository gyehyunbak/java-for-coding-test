package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15829_Hashing {
    static String str;
    static int l;
    static long sum;
    static int result;
    static final int M = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        l = Integer.parseInt(br.readLine());
        str = br.readLine();
        long pow = 1;
        for(int i=0; i<l; i++) {
            sum += (str.charAt(i) - 96) * pow % M;
            pow = pow * 31 % M;
        }
        System.out.println(sum % M);
    }
}

/* mod연산의 분배법칙을 적용하지 않은 코드 (50점)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15829_Hashing {
    static String str;
    static int l;
    static long sum;
    static int result;
    static final int M = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        l = Integer.parseInt(br.readLine());
        str = br.readLine();
        for(int i=0; i<l; i++) {
            int a = str.charAt(i) - 96;
            sum += a * Math.pow(31, i);
        }
        System.out.println(sum % M);
    }
}
 */