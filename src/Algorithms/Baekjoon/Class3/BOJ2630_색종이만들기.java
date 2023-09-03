package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630_색종이만들기 {
    static int n;
    static int blue = 0;
    static int white = 0;
    static int[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        나누기(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void 나누기(int x, int y, int size) {
        if(색확인(x, y, size)) {
            if(paper[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        
        int half = size / 2;
        나누기(x, y + half, half);
        나누기(x, y, half);
        나누기(x + half, y, half);
        나누기(x + half, y + half, half);
    }
    
    public static boolean 색확인(int x, int y, int size) {
        // 색이 다 같으면 true, 아니면 false
        int color = paper[x][y];
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(paper[i][j] != color) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
