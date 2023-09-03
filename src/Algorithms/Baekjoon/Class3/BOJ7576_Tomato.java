package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576_Tomato {
    static int[][] box;
    static boolean[][] visited;
    static int m, n;
    static int days = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        box = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) {
                    visited[i][j] = true;
                }
            }
        }

        bfs();

        System.out.println(checkAllRipened() ? days : -1);
    }

    // 모든 토마토가 익었는지 확인
    private static boolean checkAllRipened() {
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(box[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(box[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            // 현재 큐의 사이즈만큼 반복 = 현재 익은 토마토 개수만큼 반복
            // 여기서 queue.size()를 for문의 조건문 안에 넣는 실수를 했는데, 이 경우 queue.size()를 각 반복마다 새로 계산해서 한 사이클이 본래 크기만큼 돌지 않고 계속 늘어났다.
            int size = queue.size();
            for(int i=0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 &&
                            nx < m &&
                            ny >= 0 &&
                            ny < n &&
                            box[nx][ny] == 0 &&
                            !visited[nx][ny]) {
                        box[nx][ny] = 1;
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

            // 새로 익은 토마토가 있을 경우 큐는 비어있지 않음 = 하루 추가
            if(!queue.isEmpty()) {
                days++;
            }
        }
    }
}
