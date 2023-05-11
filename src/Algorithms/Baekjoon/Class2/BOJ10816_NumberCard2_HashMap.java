package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//https://st-lab.tistory.com/267 참고할 것

public class BOJ10816_NumberCard2_HashMap {
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " "); // StringTokenizer 를 굳이 두 개 안 써도 된다

        Map<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<n; i++) {
            int item = Integer.parseInt(st.nextToken());
            if(!hm.containsKey(item)) {
                hm.put(item, 1);
            } else {
                hm.put(item, hm.get(item) + 1);
            }
        }
        // hm.put(item, hm.getOrDefault(item, 0) + 1); 를 해주어 if문 없이 한줄로 표현할 수도 있다

        /*for (Map.Entry<Integer, Integer> entrySet : hm.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        }*/

        /*for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열은 반드시 정렬된 상태에서 탐색되어야 한다
        Arrays.sort(arr);*/

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
            int key = Integer.parseInt(st2.nextToken());
            //System.out.println(result);
            if(hm.containsKey(key)) {
                sb.append(hm.get(key)).append('\n');
            } else {
                sb.append(0).append('\n');
            }
            // 마찬가지로 sb.append(hm.getOrDefault(key, 0)).append(' '); 를 해줄 수도 있다
        }

        System.out.println(sb);
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
