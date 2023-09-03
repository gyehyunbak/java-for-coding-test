package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026_적록색약 {
    static int n;
    static char[][] grid;
    static boolean[][] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        visited = new boolean[n][n];

        // 일반 그리드
        for (int i = 0; i < n; i++) {
            String newLine = br.readLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = newLine.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, grid[i][j]);
                    cnt++;
                }
            }
        }

        System.out.print(cnt + " ");


        // 적록색약 그리드 (변수 초기화 + 색깔 업데이트)
        cnt = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'G') {
                    grid[i][j] = 'R'; // 적록색약은 R과 G가 같으므로 G를 찾아서 R로 바꿔준다
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, grid[i][j]);
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }

    public static void dfs(int x, int y, char color) {
        if (!isValid(x, y, color)) {
            return;
        }
        visited[x][y] = true;
        dfs(x + 1, y, color);
        dfs(x - 1, y, color);
        dfs(x, y + 1, color);
        dfs(x, y - 1, color);
    }

    public static boolean isValid(int x, int y, char color) {
        return x >= 0 && x < n && y >= 0 && y < n && !visited[x][y] && grid[x][y] == color;
    }
}
