package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21736_헌내기는친구가필요해 {
    static char[][] graph;
    static boolean[][] visited;
    static int n, m;
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        visited = new boolean[n][m];
        int startX = -1;
        int startY = -1;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == 'I') {
                    startX = i;
                    startY = j;
                }
                graph[i][j] = input.charAt(j);
            }
        }

        bfs(startX, startY);

        if (total != 0) {
            System.out.println(total);
        } else {
            System.out.println("TT");
        }
    }

    public static void dfs(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m
                && graph[x][y] != 'X' && !visited[x][y]) {
            visited[x][y] = true;
            if (graph[x][y] == 'P') {
                total++;
            }
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            if (graph[cx][cy] == 'P') {
                total++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                        && graph[nx][ny] != 'X' && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
