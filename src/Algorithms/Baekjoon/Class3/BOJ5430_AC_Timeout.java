package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ5430_AC_Timeout {
    public static boolean error = false;    // 에러 여부 추적

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());    // 테스트 케이스 수 T
        for (int i = 0; i < t; i++) {
            String command = br.readLine();                 // 수행할 함수 명령어
            int n = Integer.parseInt(br.readLine());        // 배열 개수 N
            ArrayDeque<Integer> deq = new ArrayDeque<>();  // 덱을 활용

            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            while (st.hasMoreTokens()) {
                deq.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < command.length(); j++) {
                switch (command.charAt(j)) {
                    case 'D':
                        D(deq);
                        break;
                    case 'R':
                        R(deq);
                        break;
                }
            }

            // 결과 출력
            if (error) {
                System.out.println("error"); // 에러를 한 번만 출력하기 위해 따로 전역 변수를 만들었다
            } else {
                // 1개의 요소가 남은 상태에서 요소를 제거하고 나서 출력을 하는 경우를 따지지 않아 NoSuchElementException이 발생했다.
                // 수정을 위해 요소가 남아있는지 확인 먼저 하도록 했다.
                StringBuilder sb = new StringBuilder();
                sb.append('[');     // StringBuilder 에 일단 '[' 가 추가되고, 덱에 요소가 없다면 요소를 Iterator를 통해 추가하는 과정은 생략한다.
                if(!deq.isEmpty()) {
                    Iterator<Integer> it = deq.iterator();
                    sb.append(it.next());
                    while (it.hasNext()) {
                        sb.append(',').append(it.next());
                    }
                }
                sb.append(']');
                System.out.println(sb);
            }

            error = false;
        }
    }

    public static void D(ArrayDeque<Integer> deq) {
        if (deq.isEmpty()) {
            error = true;
        } else {
            deq.removeFirst();
        }
    }

    public static void R(ArrayDeque<Integer> deq) {    // 덱을 뒤집기 위해 임시 덱에 옮겼다가 다시 옮긴다
        if(!deq.isEmpty()) {
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            while (!deq.isEmpty()) {
                tmp.addFirst(deq.removeLast());  // 덱의 뒤쪽부터 임시 덱으로 추가한다.
            }
            while (!tmp.isEmpty()) {   // 임시 덱을 원래 덱으로 복사한다
                deq.addFirst(tmp.removeFirst());
            }
        }
    }
}
