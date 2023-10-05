package Algorithms.Baekjoon.Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);

        int current = 0;
        int total = 0;

        for (int i : arr) {
            current += i;
            total += current;
            //System.out.println("current: " + current +"\ntotal: " + total);
        }

        System.out.println(total);
    }
}