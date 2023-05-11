package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11866_Josephus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        //처음에는 큐를 하나 더 만들어서 결과값을 저장하고 해당 큐를 반복문으로 출력했다
        //Queue<Integer> result = new LinkedList<>();
        //그러나 최적화를 위해 StringBuilder 를 이용하는 방법을 채택했다. 매 결과값을 문자열로 추가하여 StringBuilder 를 출력한다.
        //근데 별 차이가 없네ㅋㅋㅋ(244ms vs 196ms) (29424KB vs 28748KB)
        //매번 큐에 추가할 때 임시 변수에 옮기지 않고 바로 추가하는 걸로 바꿨더니 좀 더 빨라졌다 (184ms) (23448KB)
        StringBuilder sb = new StringBuilder();


        for(int i=1; i<=n; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            for(int i=0; i<k - 1; i++) {
                //int tmp = queue.remove();
                queue.add(queue.remove());
            }
            sb.append(", ").append(queue.remove());
            //result.add(queue.remove());
        }

        System.out.println("<" + sb.substring(2) + ">");

//        System.out.print("<" + result.remove());
//        while(!result.isEmpty()) {
//            System.out.print(", " + result.remove());
//        }
//        System.out.print(">");
    }
}
