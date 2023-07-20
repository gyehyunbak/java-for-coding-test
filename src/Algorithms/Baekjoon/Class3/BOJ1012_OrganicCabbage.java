package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1012_OrganicCabbage {
    static int[] parent;
    static int[][] cabbages;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            cabbages = new int[k][2];
            parent = new int[k];

            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbages[i][0] = x;
                cabbages[i][1] = y;
                parent[i] = i;
            }

            System.out.println(getWormNumber(k));
        }
    }

    public static int getWormNumber(int k) {
        System.out.println(Arrays.toString(parent));
        // 각 배추가 다른 배추와 근접한지 조사하고, 근접한 경우 같은 그룹넘버를 갖게 한다.
        for(int i=0; i<k; i++) {
            for(int j=i+1; j<k; j++) {
                if(isAdjacent(cabbages[i], cabbages[j])) {
                    unionParent(i, j);
                    System.out.println(Arrays.toString(parent));
                }
            }
        }

        // 자기 자신을 가리키는 부모노드의 개수가 곧 서로 다른 그룹의 개수이다.
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (parent[i] == i) {
                count++;
            }
        }

        return count;
    }

    public static boolean isAdjacent(int[] a, int[] b) {
        int x1 = a[0];
        int y1 = a[1];
        int x2 = b[0];
        int y2 = b[1];
        return (x1 == x2 && Math.abs(y1 - y2) == 1) || (y1 == y2 && Math.abs(x1 - x2) == 1);
    }

    public static int getParent(int a) {
        if(parent[a] == a) {
            return a;
        }
        return getParent(parent[a]);
    }

    public static void unionParent(int a, int b) {
        int rootA = getParent(a);
        int rootB = getParent(b);
        if(rootA < rootB) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
        }
    }
}


/*
문제 접근

테스트케이스 (입력: 10 8 17)
1 0 0 0 0 0 0 0
1 1 0 0 0 0 0 0
0 0 0 0 1 0 0 0
0 0 0 0 1 0 0 0
0 0 1 1 0 1 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 1 1 1 0
0 0 0 0 1 1 1 0
0 0 0 0 1 1 1 0

위 경우 5마리가 필요하다. 서로 인접한 배추들의 구역이 5개로 나뉘어지기 때문이다.
-> 결론적으로 서로 떨어진 구역의 개수를 찾는 문제다.
-> 각 배추가 인접했는지 어떻게 알 것인가?
그래프? BFS/DFS?

알고리즘 추론

1. 모든 배추는 하나의 리스트에 담기며 최초에 1부터 K까지의 그룹넘버를 배당받는다.
2. 리스트의 각 배추에 대해 순서대로 다른 배추와의 근접 여부를 조사한다.
    2.2 조사 대상이 된 배추와 근접함(x와 y값 중 하나가 1 차이남)이 확인된 배추는 같은 그룹넘버를 배당받는다.
        2.2.1 그룹넘버는 두 배추 중 낮은 숫자로 결정된다.
    2.3 리스트의 모든 배추에 대해 위의 과정을 반복한다. 단, 앞의 배추와의 근접여부는 이미 조사했으므로 다시할 필요 없다.
3. 서로 다른 그룹 넘버의 개수를 출력한다.

* 리스트 내 배추는 x좌표, y좌표, 그룹넘버를 저장할 수 있어야 한다.
* 모든 과정이 끝나면 가장 큰 그룹넘버를 탐색해야 한다.
* 리스트는 2차원 배열로 구현했다.

문제 1) 배추가 U자로 심어진 경우 카운트가 +1된다.
입력)
1
3 2 5
0 0
2 0
0 1
1 1
2 1
출력)
2
정답)
1

문제점)
{2,0}은 {2,1}과 인접하고, {1,1}은 {2,1}과 인접하다.
그러나 최종적으로 {1,1}과 {2,1}이 같은 그룹넘버로 배정된 후, 앞선 {2,0}은 그 그룹넘버가 업데이트되지 않는다.

해결)
그러니까 두 배추가 인접하다고 판단되어 같은 그룹에 배정하려는 순간,
해당 그룹에 먼저 속한 모든 배추에 대해 같은 그룹임이 보장되어야 한다.
UNION-FIND 알고리즘을 통해서 Parent 배열을 따로 이용해, 각 노드의 집합을 찾고, 연결할 수 있도록 하였다.

 */