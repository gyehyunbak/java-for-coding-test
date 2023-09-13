package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1679_숨바꼭질 {
    static int[] graph = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bfs(n);
        System.out.println(graph[k]);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        graph[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == k) break;
            if (curr + 1 < 100001 && !visited[curr + 1]) {
                queue.offer(curr + 1);
                visited[curr + 1] = true;
                graph[curr + 1] = graph[curr] + 1;
            }
            if (curr - 1 >= 0 && !visited[curr - 1]) {
                queue.offer(curr - 1);
                visited[curr - 1] = true;
                graph[curr - 1] = graph[curr] + 1;
            }
            if (curr * 2 < 100001 && !visited[curr * 2]) {
                queue.offer(curr * 2);
                visited[curr * 2] = true;
                graph[curr * 2] = graph[curr] + 1;
            }
        }
    }
}
