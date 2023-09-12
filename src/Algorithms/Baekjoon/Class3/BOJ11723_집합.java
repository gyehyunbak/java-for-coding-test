package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int s = 0; // 비트마스크 변수
        StringTokenizer st;

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("all")) {   // all
                s = (1 << 21) - 1;
            } else if (cmd.equals("empty")) {    // empty
                s = 0;
            } else {
                int x = Integer.parseInt(st.nextToken());

                if (cmd.equals("add")) {                     // all
                    s |= (1 << x);
                } else if (cmd.equals("remove")) {          // remove
                    s &= ~(1 << x);
                } else if (cmd.equals("check")) {           // check
                    if ((s & (1 << x)) == (1 << x)) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                } else if (cmd.equals("toggle")) {          // toggle
                    s ^= (1 << x);
                }
            }
        }

        System.out.println(sb);
    }
}
