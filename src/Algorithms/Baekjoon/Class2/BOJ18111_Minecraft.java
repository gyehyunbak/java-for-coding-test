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
        if (this.time != o.time) {         // 매개변수가 더 클 때
            return this.time - o.time;     // 음수 리턴: 오름차순, 양수 리턴: 내림차순
        }
        return o.height - this.height;
    }
}

public class BOJ18111_Minecraft {
    static int[][] map;
    static ArrayList<Result> results = new ArrayList<>(257); // 0 ~ 256 의 높이의 결과

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        map = new int[n][m];    // 각 타일 높이를 저장할 배열

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 리스트의 모든 높이에 대해 최대시간으로 초기화
        for (int i = 0; i < 257; i++) {
            results.add(new Result(i, Integer.MAX_VALUE));
        }

        // 알고리즘:
        // 모든 가능한 높이 i에 대해 256부터 0까지
        // 1. i보다 높은 블록을 모두 판다. (팔때마다 b에 +1)
        // 2. i보다 낮은 블록 위에 블록을 쌓는다.
        //  - 블록이 부족한 경우 시간을 갱신하지 않는다.
        // 3. 다 쌓았을 때 걸리는 시간을 해당 높이에 대해 results 에 갱신한다.
        // 4. 매 반복마다 map과 시간과 블럭 개수를 초기 상태로 돌려준다.

        // 모든 가능한 높이 i에 대해 256부터 0까지
        for (int i = 256; i >= 0; i--) {
            // 초기화
            int time = 0;
            int blocksObtained = 0; // 파서 얻은 블록수(=파는 횟수)
            int blocksNeeded = 0; // 쌓아야될 블록수(=쌓는 횟수)

            // map 의 모든 블록 좌표에 대해서
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    // 1. i보다 높은 블록을 모두 판다. (팔때마다 판만큼 b에 더한다)
                    if (map[j][k] > i) {
                        blocksObtained += map[j][k] - i; // i까지 파는 얻는 블록을 센다. (파고 인벤에 넣은 횟수)
                    }
                    // 2. i보다 낮은 블록 위에 블록을 쌓는다.
                    else if (map[j][k] < i) {
                        blocksNeeded += i - map[j][k]; // i까지 쌓는데 필요한 블록을 센다. (쌓은 횟수)
                    }
                }
            }

            // 3. 다 쌓았을 때 걸리는 시간을 해당 높이에 대해 results 에 갱신한다.
            // 필요한 블록 개수만큼 충분히 가지고 있는 경우 블럭을 쌓고 쌓은 시간만큼 더한 후 해당 높이에 대해 시간 갱신
            // 블록이 부족한 경우 초기값 최대치에서 갱신하지 않고 둔다.
            if (blocksNeeded <= blocksObtained + b) {
                time += blocksNeeded + (blocksObtained * 2);
                results.get(i).time = time;
            }
        }

        // 결과 리스트를 각각 걸린 시간에 대해 정렬한다(걸린 시간이 같은 경우 높이에 대해 내림차순 정렬한다)
        Collections.sort(results);

        // 리스트의 가장 앞에 것을 출력한다.
        System.out.println(results.get(0).toString());
    }
}
