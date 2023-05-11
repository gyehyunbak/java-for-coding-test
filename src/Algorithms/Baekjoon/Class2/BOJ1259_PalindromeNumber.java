package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1259_PalindromeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        whileLoop:
        while(true) {
            String str1 = br.readLine();

            if(str1.equals("0")) break;

            sb = new StringBuilder(str1);
            int len = str1.length();
            String str2 = sb.reverse().toString();  // 숫자를 문자열로 입력 받고 뒤집은 문자열을 하나 따로 만든다

            // 원래 문자열과 뒤집어진 문자열을 문자 하나씩 앞에서부터 절반까지 비교하며 서로 다른게 발견되면 "no"를 출력하고 끝낸다
            for(int i=0; i<(len/2) + 1; i++) {
                if(str1.charAt(i) != str2.charAt(i)) {
                    System.out.println("no");
                    continue whileLoop;
                }
            }

            // 비교가 완료되면 양쪽 절반 문자열이 같으므로 "yes"를 출력한다
            System.out.println("yes");
        }
    }
}
