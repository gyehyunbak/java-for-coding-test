package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10773_Zero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<k; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0 && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        int sum = 0;
        for(int num : stack) {
            sum += num;
        }
        System.out.println(sum);
    }
}