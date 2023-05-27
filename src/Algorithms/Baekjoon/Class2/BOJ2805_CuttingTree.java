package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805_CuttingTree {
    // int 로 했다가 틀려서 long 으로 바꿈
    static int n;
    static long m;
    static long[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        trees = new long[n];

        // 자르는 지점 k를 0부터 제일 높은 나무 높이 사이에 지정. 각 원소에서 k를 뺸 값을 합하면 내가 얻는 나무 길이
        // 합한 값 sum 이 내가 필요한 M보다 크다 -> k보다 큰 부분에서 절반
        // 합한 값 sum 이 내가 필요한 M보다 작다 -> k보다 작은 부분에서 절반
        // 정확히 일치하지 않으면? -> 원소가 하나 남을때까지 반복
        for(int i=0; i<n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        long result = bSearch(0, trees[n-1]);
        System.out.println(result);
    }

    public static long bSearch(long low, long high) {
        //System.out.println("low: " + low + " high: " + high + " mid: " + (low+high)/2);
        if(low > high) {
            return high; // 못 찾아도 최댓값을 제공해야 하기 때문에
        }

        long mid = (low + high) / 2;
        long sum = 0;
        // 높이에서 잘랐을 때 구할 수 있는 목재 길이
        for(int i=0; i<trees.length; i++) {
            if(trees[i] > mid) sum += trees[i] - mid;
        }
        //System.out.println("sum : " + sum);

        // 목재의 길이에 대해 이분 탐색
        if(sum == m) {
            return mid;
        }
        else if(sum > m) {
            return bSearch(mid + 1, high);
        }
        else {
            return bSearch(low, mid - 1);
        }
    }
}
