package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978_FindingPrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // n은 그러고보니 쓰이질 않았다. readLine()으로 넘겨버려도 될 듯.
        st = new StringTokenizer(br.readLine());
        int cnt = 0;

        // 각 반복문에 라벨을 붙일 수 있다는 걸 알았다.
        // 원래는 주어진 숫자가 1 혹은 다른 수로 나누어떨어질 때마다 해당 숫자를 더하고 전체에서 뺄 생각이었다.
        LoopWhile :
        while(st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            if(x == 1) continue;

            for(int i = 2; i<x; i++) {
                if(x%i == 0){
                    continue LoopWhile;
                }
            }
            // 1이 아니고 자신을 제외한 다른 수로 나누어지지 않은 경우(1 제외)에만 루프를 끝까지 돌고 나와 카운트된다.
            cnt++;
        }
        System.out.println(cnt);
    }
}
