package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10845_Queue {
    // 큐가 될 정수 배열과 사이즈를 추적할 정수 변수 선언
    public static int[] queue;
    public static int tail = 0;
    public static int head = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        queue = new int[N];

        // N개의 각 명령어가 입력될 때마다 StringBuilder에 추가해서 while문이 끝나면 출력
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push": push(Integer.parseInt(st.nextToken())); break;
                case "pop": sb.append(pop()).append('\n'); break;
                case "size": sb.append(size()).append('\n'); break;
                case "empty": sb.append(empty()).append('\n'); break;
                case "front": sb.append(front()).append('\n'); break;
                case "back": sb.append(back()).append('\n'); break;
            }
        }

        System.out.println(sb);
    }

    // 스택 구현
    public static void push(int item) {
        queue[tail] = item;
        tail++;
    }

    public static int pop() {
        if(tail - head == 0) {
            return -1;
        } else {
            int result = queue[head];
            queue[head] = 0;
            head++;
            return result;
        }
    }

    public static int size() {
        return tail - head;
    }

    public static int empty() {
        if(tail - head == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int front() {
        if(tail - head == 0) {
            return -1;
        }
        else {
            return queue[head];
        }
    }
    public static int back() {
        if(tail - head == 0) {
            return -1;
        }
        else {
            return queue[tail - 1];
        }
    }
}
