package Algorithms.ThisIsCodingTest.Greedy;
import java.util.*;

public class Greedy4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, K를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int tmp = (n / k) * k;   // 만약 N = 26, K = 3이라면 target = 8 * 3 = 24
            System.out.println("tmp: " + tmp);
            result += (n - tmp);     // result += 26 - 24 = 0 + 2 = 2
            System.out.println("cnt: " + result);
            n = tmp;                 // N = 24
            System.out.println("n: " + n);
            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) break;
            // K로 나누기
            result += 1;
            System.out.println("cnt: " + result);
            n /= k;                     // N = N/K = 24/3 = 8
            System.out.println("n: " + n);
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        System.out.println("cnt: " + result);
        result += (n - 1);
        System.out.println(result);
    }
}
