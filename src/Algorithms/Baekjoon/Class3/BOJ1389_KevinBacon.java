package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1389_KevinBacon {
    static int n, m;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 입력 그래프 생성
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 입력
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 최솟값 추적 변수
        int minNumber = Integer.MAX_VALUE;
        int minUser = 0;

        // 최솟값 갱신
        for(int i=1; i<= n; i++) {
            int kevinBaconNumber = calculateKevinBaconNumber(graph, i);
            if(kevinBaconNumber < minNumber) {
                minNumber = kevinBaconNumber;
                minUser = i;
            }
        }

        System.out.println(minUser);
    }

    public static int calculateKevinBaconNumber(List<List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] kevinBaconNumbers = new int[n + 1];

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int neighbor : graph.get(current)) {
                if(!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    kevinBaconNumbers[neighbor] = kevinBaconNumbers[current] + 1;
                }
            }
        }

        // 총 케빈 베이컨 수 합산
        int totalKevinBaconNumber = 0;
        for(int i = 1; i <= n; i++) {
            totalKevinBaconNumber += kevinBaconNumbers[i];
        }

        return totalKevinBaconNumber;
    }
}
