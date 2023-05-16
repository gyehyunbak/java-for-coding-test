package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph {
    class Node{
        int data;
        LinkedList<Node> adjacent;  // 인접 노드
        boolean marked;     // 방문했는지 마킹하는 플래그
        Node (int data) {   // 노드 선언
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }
    Node[] nodes;   // 노드 배열
    Graph(int size) {   // 그래프 선언
        nodes = new Node[size];
        for(int i=0; i<size; i++) {    // 주어진 사이즈만큼 노드 생성
            nodes[i] = new Node(i+1);
        }
    }
    void addEdge(int i1, int i2) {  // 두 노드 사이 에지 추가 메소드
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {    // 각 노드에 상대 노드가 링크드리스트에 존재하지 않으면
            n1.adjacent.add(n2);            // 해당 노드를 인접 링크드리스트에 추가
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }
    void dfs() {
        dfs(0);
    }
    void dfs(int index) {   // dfs
        Node root = nodes[index];   // 루트 노드로 입력 인덱스 노드를 가져옴
        Stack<Node> stack = new Stack<Node>();  // dfs를 위해 스택 이용
        stack.push(root);
        root.marked = true; // 루트 노드를 스택에 추가
        // 스택이 빌 때까지 반복
        while(!stack.isEmpty()) {
            Node r = stack.pop();
            for(Node n : r.adjacent) {  // 인접 노드에 대해 반복 (큰 수 먼저하려면? 정렬? 정렬삽입?)
                if(!n.marked) { // 방문된 노드인지 확인
                    n.marked = true;
                    stack.push(n);  // 스택에 추가
                }
            }
            visit(r);
        }
        System.out.println();
    }

    void dfsR(Node r) { // DFS 의 재귀버전
        if(r == null) return;
        r.marked = true;
        visit(r);
        for(Node n : r.adjacent) {
            if(!n.marked) {
                dfsR(n);
            }
        }
    }
    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }

    void bfs() {
        bfs(0);
    }
    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.marked = true;
        while(!queue.isEmpty()) {
            Node r = queue.remove();
            for(Node n : r.adjacent) {
                if(!n.marked) {
                    n.marked = true;
                    queue.add(n);
                }
            }
            visit(r);
        }
        System.out.println();
    }
    void visit(Node n) {    // 방문된 노드 출력
        System.out.print(n.data + " ");
    }

    void reset() {  // 배열의 방문 마크 초기화
        for(Node n : nodes) {
            for(Node k : n.adjacent) {
                k.marked = false;
            }
        }
    }
}

public class BOJ1260_DFS_BFS_Failed {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(n);

        int[][] arr = new int[m][2];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
//            int a = Integer.parseInt(st.nextToken()) - 1;
//            int b = Integer.parseInt(st.nextToken()) - 1;
//            graph.addEdge(a, b);
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0] ? o1[0]-o2[0] : o1[1]-o2[1];
            }
        });

        for(int i=0; i<m; i++) {
            graph.addEdge(arr[i][0]-1,arr[i][1]-1);
        }

        graph.dfsR(v-1);
        System.out.println();   // 재귀 버전은 마지막 호출 후 직접 줄바꿈 넣어준다.
        graph.reset(); // 한 번 알고리즘 호출 후 marked 값을 초기화해줘야 한다.
        graph.bfs(v-1);
    }
}
