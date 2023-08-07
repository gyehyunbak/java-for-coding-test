package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1620_PokemonMaster {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>(n);
        HashMap<String, String> map2 = new HashMap<>(n);
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            map.put(String.valueOf(i+1), input);
            map2.put(input, String.valueOf(i+1));
        }
        for(int i=0; i<m; i++) {
            String input = br.readLine();
            if(map.get(input) != null) {
                System.out.println(map.get(input));
            } else {
                System.out.println(map2.get(input));
            }
        }
    }
}
