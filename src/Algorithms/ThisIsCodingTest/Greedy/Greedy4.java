package Algorithms.ThisIsCodingTest.Greedy;

import java.util.*;

public class Greedy4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;

        while(n > 1) {
            if(n % k != 0) {
                n -= 1;
                cnt++;
            }
            else {
                n = n / k;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
