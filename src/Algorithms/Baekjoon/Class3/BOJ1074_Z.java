package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074_Z {
    static int[][] arr;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2, n);

        // arr = new int[size][size];
        //dnc(0, 0, size-1, size-1); 메모리초과
        //System.out.println(arr[r][c]);

        dnc2(size, r, c);
        System.out.println(cnt);
    }

    // 메모리초과
    public static void dnc(int sx, int sy, int ex, int ey) {
        if(ex - sx == 1) {
            arr[sy][sx] = cnt++;
            arr[sy][ex] = cnt++;
            arr[ey][sx] = cnt++;
            arr[ey][ex] = cnt++;
        } else {
            int mx = (ex + sx) / 2;
            int my = (ey + sy) / 2;
            dnc(sx, sy, mx, my);
            dnc(mx+1, sy, ex, my);
            dnc(sx, my+1, mx, ey);
            dnc(mx+1, my+1, ex, ey);
        }
    }

    // 어느 사분면에 속해있는지 확인해서 재귀호출
    public static void dnc2(int size, int r, int c) {
        if(size == 1) {
            return;
        }

        if(r < size/2 && c < size/2) {
            dnc2(size/2, r, c);
        } else if(r < size/2 && c >= size/2) {
            cnt += (size * size) / 4;
            dnc2(size/2, r, c - size/2);
        } else if (r >= size/2 && c < size/2) {
            cnt += (size * size) / 4 * 2;
            dnc2(size/2, r - size/2, c);
        } else if (r >= size/2 && c >= size/2) {
            cnt += (size * size) / 4 * 3;
            dnc2(size/2, r - size/2, c - size/2);
        }
    }
}
