package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1920_FindingNumber_NoLibraries {
    public static int[] arr;
    public static int[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++) {
            if(binarySearch(0, n, Integer.parseInt(st2.nextToken())) != -1) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static int binarySearch(int low, int high, int item) {
        if(high - low < 0) return -1;
        int mid = (high - low) / 2;
        if(arr[mid] == item) {
            return mid;
        } else if(arr[mid] > item) {
            return binarySearch(mid+1, high, item);
        } else {
            return binarySearch(low, mid-1, item);
        }
    }
}
