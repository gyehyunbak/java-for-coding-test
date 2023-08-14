package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // ArrayList는 시간초과, HashSet을 함께 사용
        HashSet<String> hs = new HashSet<>(n);
        ArrayList<String> al = new ArrayList<>();
        for(int i=0; i<n; i++) {
            hs.add(br.readLine());
        }
        for(int i=0; i<m; i++) {
            String input = br.readLine();
            if(hs.contains(input)) {
                al.add(input);
            }
        }
        Collections.sort(al);
        System.out.println(al.size());
        for(String i : al) {
            System.out.println(i);
        }
    }
}
