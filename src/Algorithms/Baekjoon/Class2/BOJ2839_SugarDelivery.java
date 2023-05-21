package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839_SugarDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 5키로 짜리가 많을 수록 가져가야할 봉지는 적어진다. (그리디)
        // 1. n을 5로 나눈 몫과 나머지를 구해 5키로 짜리가 몇 봉지인지 저장한다.
        // 2. 구한 나머지가 3으로 나누어 떨어지면 해당 몫을 결과에 더한다.
        // 3. 구한 나머지가 3으로 나누어떨어지지 않을 경우, 저장한 5키로 짜리 봉지 개수에서 하나를 취소한다.
        //    즉, 저장한 5키로 봉지 개수에서 하나를 빼고 나누어떨어지지 않는 몫에 5를 더한다.
        //    해당 액션을 몫이 3으로 나누어 떨어질 때까지 반복한다.
        // 4. 5키로 짜리가 더 이상 없고, 3으로 나누어떨어지지 않을 경우 -1을 반환한다.

        // 1. n을 5로 나눈 몫과 나머지를 구해 5키로 짜리가 몇 봉지인지 저장한다.
        int fiveKilo, threeKilo;
        fiveKilo = n / 5;
        n %= 5;

        while(true) {
            // 2. 구한 나머지가 3으로 나누어 떨어지면 해당 몫을 결과에 더한다.
            if(n%3 == 0) {
                threeKilo = n / 3;
                System.out.println(fiveKilo + threeKilo);
                break;
            }
            // 3. 구한 나머지가 3으로 나누어떨어지지 않고 5키로 봉지가 남아있는 경우
            // 저장한 5키로 짜리 봉지 개수에서 하나를 취소하고 몫에 더하고 재확인한다.
            else if(fiveKilo > 0) {
                fiveKilo--;
                n += 5;
            }
            // 4. 5키로 짜리가 더 이상 없고, 3으로 나누어떨어지지 않을 경우 -1을 반환한다.
            else {
                System.out.println(-1);
                break;
            }
        }
    }
}
