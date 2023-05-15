package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ5430_AC {
    public static boolean error = false;    // 에러 여부 추적
    // 최초엔 배열을 복제해서 뒤집는 과정에서 시간초과가 났으므로, 해결을 위해 삭제 방향을 추적하는 변수를 따로 두었다.
    public static boolean isRight = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());    // 테스트 케이스 수 T
        for (int i = 0; i < t; i++) {
            String command = br.readLine();                // 수행할 함수 명령어
            int n = Integer.parseInt(br.readLine());       // 배열 개수 N (안 썼다)
            ArrayDeque<Integer> deq = new ArrayDeque<>();  // 덱을 활용

            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            while (st.hasMoreTokens()) {
                deq.add(Integer.parseInt(st.nextToken()));
            }

            // 함수 호출 해석 및 실행
            for (int j = 0; j < command.length(); j++) {
                switch (command.charAt(j)) {
                    case 'D':
                        D(deq);
                        break;
                    case 'R':
                        // 따로 뒤집는 함수를 이용하지 않고 isRight 변수만 바꿔준다.
                        isRight = !isRight;
                        //R(deq);
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

                if (!deq.isEmpty()) { // 요소가 있을 때만 실행한다. 없으면 넘어가서 "[]"이 최종 결과가 된다.
                    if (!isRight) {
                        sb.append(deq.removeFirst());
                        while (!deq.isEmpty()) {
                            sb.append(',').append(deq.removeFirst());
                        }
                    } else {
                        sb.append(deq.removeLast());
                        while (!deq.isEmpty()) {
                            sb.append(',').append(deq.removeLast());
                        }
                    }
                }

                sb.append(']');
                System.out.println(sb);
            }

            error = false;
            isRight = false;
        }
    }

    public static void D(ArrayDeque<Integer> deq) {
        if (deq.isEmpty()) {
            error = true;
        } else {
            // isRight 변수를 통해 어느 방향을 삭제할 지 결정한다.
            if (!isRight) {
                deq.removeFirst();
            } else {
                deq.removeLast();
            }
        }
    }

    // isRight 변수를 이용하기 때문에 뒤집는 함수는 따로 필요가 없게 됐다.
    /*public static void R(ArrayDeque<Integer> deq) {    // 덱을 뒤집기 위해 임시 덱에 옮겼다가 다시 옮긴다
        if(!deq.isEmpty()) {
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            while (!deq.isEmpty()) {
                tmp.addFirst(deq.removeLast());  // 덱의 뒤쪽부터 임시 덱으로 추가한다.
            }
            while (!tmp.isEmpty()) {   // 임시 덱을 원래 덱으로 복사한다
                deq.addFirst(tmp.removeFirst());
            }
        }
    }*/

    // 항상 시간초과를 생각하자.
    // 불리언 값을 잘 활용하면 유용하다.
}
