package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164_Card2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            queue.add(i);
        }

        boolean dump = true;
        while(queue.size() > 1) {
            if(dump) {
                queue.remove();
                dump = !dump;
            } else {
                queue.add(queue.remove());
                dump = !dump;
            }
        }

        System.out.println(queue.peek());
    }
}
