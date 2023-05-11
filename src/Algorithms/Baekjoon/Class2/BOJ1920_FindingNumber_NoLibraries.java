package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920_FindingNumber_NoLibraries {
    public static int[] arr;
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

        // 배열은 반드시 정렬된 상태에서 탐색되어야 한다
        Arrays.sort(arr);

        for(int i=0; i<m; i++) {
            if(myBinarySearch(0, n-1, Integer.parseInt(st2.nextToken())) != -1) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static int myBinarySearch(int low, int high, int item) {
        if(low > high) return -1;
        int mid = (high + low) / 2;
        //System.out.println("mid: " + arr[mid] + " item: " + item);
        if(arr[mid] == item) {
            return mid;
        } else if(arr[mid] < item) {
            // 중간값보다 찾고자 하는 값이 크다 -> 중간값 오른쪽 탐색
            return myBinarySearch(mid+1, high, item);
        } else {
            // 중간값보다 찾고자 하는 값이 작다 -> 중간값 왼쪽 탐색
            return myBinarySearch(low, mid-1, item);
        }
    }
}
