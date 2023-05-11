package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2798_BlackJack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[n];
        HashSet<Integer> sums = new HashSet();

        int l = 0;
        while(st.hasMoreTokens()) {
            numbers[l++] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                for(int k=j+1; k<n; k++) {
                    int x = numbers[i];
                    int y = numbers[j];
                    int z = numbers[k];
                    if(x+y+z <= m) sums.add(x+y+z);
                }
            }
        }

        System.out.println(Collections.max(sums));
    }
}
