package Algorithms.Baekjoon.Class3;

import java.util.*;

public class BOJ1260_DFS_BFS {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        A = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }
        for(int i=1; i<=N; i++) {    // 작은 수 먼저 방문을 위해 정렬
            Collections.sort(A[i]);
        }

        visited = new boolean[N+1];  // 각 노드 방문 여부 배열
        DFS(V);
        System.out.println();
        visited = new boolean[N+1];  // 방문 여부 초기화
        BFS(V);
        System.out.println();
    }

    private static void BFS(int node) {     // 큐로 구현한 BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while(!queue.isEmpty()) {   // 큐가 빌 때까지 반복
            int picked = queue.poll();
            System.out.print(picked + " "); // 뽑히는 순간 출력
            for(int i : A[picked]) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void DFS(int node) {     // 재귀로 구현한 DFS
        System.out.print(node + " ");
        visited[node] = true;
        for(int i : A[node]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
}
