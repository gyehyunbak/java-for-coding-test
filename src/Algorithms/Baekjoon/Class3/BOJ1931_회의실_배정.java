package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1931_회의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int reserved = -1;
        int count = 0;
        int[][] meetings = new int[n][2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        // 그리디 문제
        // 끝나는 시간 기준 오름차순 정렬(같을 경우 시작 시간 기준)한 후
        // 다음 회의의 시작 시간이 바로 전 회의의 끝난 시간 이후라면 예약에 추가한다.
        // 자바의 2차원 배열 정렬을 위해서는 Comparator 익명클래스를 구현할 수 있다.
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        for(int i=0; i<n; i++) {
            if(meetings[i][0] >= reserved) {
                reserved = meetings[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
