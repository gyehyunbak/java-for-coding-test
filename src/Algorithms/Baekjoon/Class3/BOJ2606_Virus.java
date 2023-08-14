package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2606_Virus {
    static boolean[] visited;
    static List<List<Integer>> computers;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        computers = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            computers.add(new LinkedList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers.get(a).add(b);
            computers.get(b).add(a);
        }

        //dfs(1);
        bfs(1);

        System.out.println(cnt);
    }

    public static void dfs(int start) {
        visited[start] = true;
        for(Integer i : computers.get(start)) {
            if(!visited[i]) {
                cnt++;
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int i : computers.get(current)) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
    }
}
