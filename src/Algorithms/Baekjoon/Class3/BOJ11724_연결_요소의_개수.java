package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11724_연결_요소의_개수 {
    static int n, m;
    static boolean[][] graph;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
            graph[b][a] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int start) {
        visited[start] = true;
        for (int i = 1; i < n + 1; i++) {
            if (graph[start][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
}
