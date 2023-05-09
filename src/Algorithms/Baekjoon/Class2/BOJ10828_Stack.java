package Algorithms.Baekjoon.Class2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ10828_Stack {
    // 스택이 될 정수 배열과 사이즈를 추적할 정수 변수 선언
    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        stack = new int[N];

        // N개의 각 명령어가 입력될 때마다 StringBuilder에 추가해서 while문이 끝나면 출력
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push": push(Integer.parseInt(st.nextToken())); break;
                case "pop": sb.append(pop()).append('\n'); break;
                case "size": sb.append(size()).append('\n'); break;
                case "empty": sb.append(empty()).append('\n'); break;
                case "top": sb.append(top()).append('\n'); break;
            }
        }

        System.out.println(sb);
    }

    // 스택 구현
    public static void push(int item) {
        stack[size] = item;
        size++;
    }

    public static int pop() {
        if(size == 0) {
            return -1;
        } else {
            int result = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return result;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if(size == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int top() {
        if(size == 0) {
            return -1;
        }
        else {
            return stack[size - 1];
        }
    }
}
