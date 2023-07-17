package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949_BalancedWorld {
    static boolean balanced = true;
    static String str;
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            str = br.readLine();
            if(str.equals(".")) break; // 종료 조건
            stack = new Stack<>();
            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i) == '(') {
                    stack.push('(');
                } else if(str.charAt(i) == '[') {
                    stack.push('[');
                }

                if(str.charAt(i) == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        balanced = false;
                        break;
                    }
                } else if(str.charAt(i) == ']') {
                    if(!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        balanced = false;
                        break;
                    }
                }
            }
            // 처음에 모든 열린 괄호가 닫힌 경우를 따지지 않아 틀렸다.
            // stack이 비었는지 확인하는 것을 추가함으로써 모든 열린 괄호가 닫혔는지 확인한다.
            if(balanced && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            balanced = true;
        }
    }
}
