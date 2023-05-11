package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018_RepaintingChessBoard {
    public static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];

        // 체스판 상태 입력
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                if(str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        int min = 64;
        int result1 = 0;
        int result2 = 0;
        // i,j는 출발점
        for (int i=0; i<n-7; i++) {
            for (int j=0; j<m-7; j++) {
                boolean start = true;

                for (int k=i; k<i+8; k++) {
                    for (int l=j; l<j+8; l++) {
                        if(arr[k][l] != start) {
                            // 맨왼쪽위가 하얀 멀쩡한 8*8 체스판이랑 비교
                            result1++;
                        } else {
                            // 맨왼쪽위가 까만 멀쩡한 8*8 체스판이랑 비교
                            result2++;
                        }
                        start = !start;
                    }
                    start = !start;
                }
                //각 반복마다 나온 두 가지 경우의 수 중 작은 쪽과 전체 최솟값 결과와 비교해서 더 작은 값을 전체에 저장
                int iterMin = Math.min(result1, result2);
                min = Math.min(min, iterMin);
                //다음 반복을 위해 초기화
                result1 = 0;
                result2 = 0;
            }
        }

        System.out.println(min);
    }
}
