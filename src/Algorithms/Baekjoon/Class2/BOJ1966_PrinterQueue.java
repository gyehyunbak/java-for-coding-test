package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 굳이 객체 안 만들고 두 개짜리 int[] 배열로 해도 됐을 듯
class tuple {
    int idx, pri;
    public tuple(int idx, int pri) {
        this.idx = idx;
        this.pri = pri;
    }
}

public class BOJ1966_PrinterQueue {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        // 테스트 케이스 만큼 반복
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            // 큐 선언 및 입력
            LinkedList<tuple> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                queue.add(new tuple(i, Integer.parseInt(st.nextToken())));
            }

            boolean again = false;
            int cnt = 0;
            tuple tmp;

            while (!queue.isEmpty()) {
                // 맨 앞 요소 꺼내기
                tuple first = queue.get(0);
                // 맨 앞의 중요도 보다 높은게 있는지 확인
                for (int i = 1; i < queue.size(); i++) {
                    // 있을 경우 맨 앞 문서를 맨 뒤로 넣고 넘어감
                    if (first.pri < queue.get(i).pri) {
                        queue.add(queue.poll());
                        again = true;
                        break;
                    }
                }

                if (again) {
                    again = false;
                    continue;
                } else {
                    // 없을 경우 맨 앞 문서를 프린트(순서++), 찾는 문서가 맞다면 순서 출력하고 break, 아니라면 다음 반복
                    tmp = queue.poll();
                    cnt++;
                    if(tmp.idx == m) {
                        System.out.println(cnt);
                        break;
                    }
                }
            }
        }
    }
}
