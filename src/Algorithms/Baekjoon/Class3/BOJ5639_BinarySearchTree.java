package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5639_BinarySearchTree {
    static int[] tree = new int[10000];
    static void postOrder(int start, int end) {
        int i;

        if(start >= end) {  // 자식노드가 없는 경우 리턴
            return;
        }

        for(i = start + 1; i < end; i++) {  // i는 루트노드보다 큰 노드의 인덱스 = 오른쪽 트리의 루트노드
            if(tree[start] < tree[i])
                break;
        }

        postOrder(start + 1, i); // 왼쪽 트리 탐색
        postOrder(i, end);       // 오른쪽 트리 탐색
        System.out.println(tree[start]); // 루트(현재) 노드 출력
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        String input;
        while((input = br.readLine()) != null && !input.isEmpty()) { // 개수가 정해지지 않은 입력을 BufferedReader로 받는 방법
            tree[i] = Integer.parseInt(input);
            i++;
        }

        postOrder(0, i); // 최종적으로 i는 입력받은 배열의 총 크기 + 1
    }
}