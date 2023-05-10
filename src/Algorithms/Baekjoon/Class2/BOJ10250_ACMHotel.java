package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10250_ACMHotel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        int[] arr = new int[3];
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            str = br.readLine().split(" ");
            for(int j=0; j<3; j++) {
                arr[j] = Integer.parseInt(str[j]);
            }

            int floor, room;
            // H를 N으로 나눠 몫과 나머지를 구할 건데, 나누어 떨어지는 경우를 고려해줘야 한다
            if(arr[2] % arr[0] == 0) {
                floor = arr[0] * 100;
                room = arr[2] / arr[0];
            } else {
                floor = arr[2] % arr[0] * 100;
                room = arr[2] / arr[0] + 1;
            }
            // W는 쓸모가 없다는 걸 알 수 있다. 조건이 달라 방의 개수보다 손님이 초과한다면 필요해질 것이다.
            System.out.println(floor + room);
        }
    }
}
