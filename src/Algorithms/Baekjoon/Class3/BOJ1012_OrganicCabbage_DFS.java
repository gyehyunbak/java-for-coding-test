package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012_OrganicCabbage_DFS {
    static int[][] land;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int count = 0;

            // 각 땅과 방문여부 배열 초기화
            land = new int[m][n];
            visited = new int[m][n];

            // 땅의 배추 위치 입력
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                land[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            // 땅의 각 방문하지 않은 다음 배추 위치에 대해 DFS 탐색하여 인접한 배추를 방문표시 및 그룹 개수 카운트
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (land[i][j] == 1 && visited[i][j] == 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            // 최종적으로 그룹 개수 출력
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y) {
        int m = land.length;
        int n = land[0].length;

        // 현재노드의 범위, 방문여부, 인접여부
        if (x < 0 || x >= m || y < 0 || y >= n || land[x][y] == 0 || visited[x][y] == 1) {
            return;
        }

        // 방문여부 기록 및 인접노드 탐색
        visited[x][y] = 1;
        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }
}