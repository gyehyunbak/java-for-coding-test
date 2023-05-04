package Algorithms.ThisIsCodingTest.Greedy;

import java.util.Scanner;

public class Greedy4_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;

        while(n >= k) {             // N이 K보다 작아지면 루프에서 벗어나 남은 값은 모두 더한다
            int tmp = n % k;        // N을 K로 나눈 나머지
            cnt += tmp;             // 어차피 나누어 떨어질 때까지 뺄 예정이니 나머지를 카운트에 더한다
            n = n / k;              // 다 빼고 나면 나누어 떨어질 예정이니 나머지는 버리고 몫만 취한다
            cnt++;                  // 나누기를 한 번 했으니 카운트 한다
        }

        cnt += (n - 1);     // 1이 될 때까지 빼는 걸 세므로, 1을 뺀 나머지를 카운트한다

        System.out.println(cnt);
    }
}
