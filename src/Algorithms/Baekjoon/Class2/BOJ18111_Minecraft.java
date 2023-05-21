package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Result implements Comparable<Result> {  // 결과값 클래스
    int height;
    int time;

    public Result(int height, int time) {
        this.height = height;
        this.time = time;
    }

    @Override
    public String toString() {
        return this.time + " " + this.height;
    }

    @Override
    public int compareTo(Result o) {
        // 시간을 비교하고 같지 않으면 오름차순 정렬, 같으면 높이에 대해 내림차순 정렬
        if (this.time != o.time) {   // 매개변수가 더 클 때
            return this.time - o.time;     // 음수 리턴: 오름차순, 양수 리턴: 내림차순
        }
        return o.height - this.height;
    }
}

public class BOJ18111_Minecraft {
    static int[][] map_original;
    static int[][] map;
    static ArrayList<Result> results = new ArrayList<>(257); // 0 ~ 256 의 높이의 결과

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        map_original = new int[n][m];   // 초기를 상태 저장하는 배열
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map_original[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 리스트의 모든 높이에 대해 최대시간으로 초기화
        for (int i = 0; i < 257; i++) {
            results.add(new Result(i, Integer.MAX_VALUE));
        }

        // 모든 가능한 높이 i에 대해 256부터 0까지
        // 1. i보다 높은 블록을 모두 판다. (팔때마다 b에 +1)
        // 2. i보다 낮은 블록 위에 블록을 쌓는다.
        //  - 블록이 부족한 경우 시간을 갱신하지 않는다.
        // 3. 다 쌓았을 때 걸리는 시간을 해당 높이에 대해 results 에 갱신한다.
        // 4. 매 반복마다 map과 시간과 블럭 개수를 초기 상태로 돌려준다.

        // 모든 가능한 높이 i에 대해 256부터 0까지
        initialLoop:
        for (int i = 256; i >= 0; i--) {
            // 초기화
            int time = 0;
            int blocks = b;
            // map = map_original.clone();
            // 자바에서 2차원 배열의 깊은 복사는 clone()이나 다른 메서드를 활용할 경우 한 부분만 깊은 복사가 되고 더 깊은 수준의 값은 깊은 복사가 되지 않는다
            // 그래서 for문을 돌려서 일일이 복사해주어야 한다
            for (int g = 0; g < n; g++) {
                for (int h = 0; h < m; h++) {
                    map[g][h] = map_original[g][h];
                }
            }

            // 1. i보다 높은 블록을 모두 판다. (팔때마다 판만큼 b에 더한다)
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[j][k] > i) {
                        time += (map[j][k] - i) * 2; // 블럭을 파고 인벤토리에 넣는 시간 2초
                        blocks += map[j][k] - i;     // 판 블럭만큼 인벤토리에 더해준다.
                        map[j][k] = i;               // 팠으니 높이는 i와 같아진다.
                    }
                }
            }

            // 2. i보다 낮은 블록 위에 블록을 쌓는다. (블록이 부족한 경우 높이의 경우를 무시하고 넘어간다(무한대))
            int blocks_needed = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[j][k] < i) {
                        blocks_needed += i - map[j][k];
                    }
                }
            }

            // 3. 다 쌓았을 때 걸리는 시간을 해당 높이에 대해 results 에 갱신한다.
            // 필요한 블록 개수만큼 충분히 가지고 있는 경우 블럭을 쌓고 쌓은 시간만큼 더한 후 해당 높이에 대해 시간 갱신
            if (blocks_needed <= blocks) {
                time += blocks_needed;
                results.get(i).time = time;
            }

            // 아래는 이유는 모르겠는데 안 됐던거
            /*for(int j=0; j<n; j++) {
                for(int k=0; k<m; k++) {
                    if(map[j][k] < i) {
                        if(blocks < (i - map[j][k])) {
                            continue initialLoop;       // 블럭이 모자라면 다음 경우로 넘어간다.
                        } else {
                            time += i - map[j][k];      // 블럭을 쌓는데 걸리는 시간 1초
                            blocks -= i - map[j][k];    // 쌓은 만큼 인벤토리에서 빼준다.
                            map[j][k] = i;              // 쌓았으니 높이는 i와 같아진다.
                        }
                    }
                }
            }

            // 3. 다 쌓았을 때 걸리는 시간을 해당 높이에 대해 results 에 갱신한다.
            results.get(i).time = time;*/
        }

        // 결과 리스트를 각각 걸린 시간에 대해 정렬한다(걸린 시간이 같은 경우 높이에 대해 내림차순 정렬한다)
        Collections.sort(results);

        // 리스트의 가장 앞에 것을 출력한다.
        System.out.println(results.get(0).toString());

        /*// 테스트용 전체 출력
        for (int i = 0; i < 257; i++) {
            System.out.println(results.get(i).toString());
        }*/
    }
}
