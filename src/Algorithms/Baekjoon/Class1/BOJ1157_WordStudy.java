package Algorithms.Baekjoon.Class1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ1157_WordStudy {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[26]; // 영문자 26개

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 문자열 확인
        for(int i = 0; i < str.length(); i++) {
            if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {  // 대문자의 경우 (65~90)
                arr[str.charAt(i) - 65]++;
            } else {    // 소문자의 경우 (97~122)
                arr[str.charAt(i) - 97]++;
            }
        }

        int max = -1;
        char ch = '?';

        // 가장 많이 나온 것 찾기
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                ch = (char) (i + 65);
            } else if(arr[i] == max) {
                ch = '?';
            }
        }

        System.out.println(ch);
    }
}
