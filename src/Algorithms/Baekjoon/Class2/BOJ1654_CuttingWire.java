package Algorithms.Baekjoon.Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1. 랜선이 될 수 있는 최대 길이는 주어진 랜선 중 가장 짧은 것보다 길 수 없다.
// 2. 랜선의 길이는 그러므로 1부터 가장 긴 랜선(longest)까지로 경우의 수가 나뉜다.
// 3. 각 랜선의 길이로 만들 수 있는 랜선의 개수는 각각의 랜선을 해당 길이로 나눈 몫의 총합(total)이다.
// 4. 총합이 N보다 크거나 같은 길이 중 가장 긴 것을 찾으면 된다.
// 5. 모든 경우의 수를 따질 경우 경우의 수가 너무 커지므로 이분탐색을 활용한다. (우선 정렬이 필요하다)
// 6. 현재 자를 길이(cutLength)를 1부터 longest 사이의 중간에서 시작하여,
//      6.1 만들어지는 선의 개수가 N보다 크거나 같을 경우 cutLength를 뒤의 절반에서 탐색하고,
//      6.2 만들어지는 선의 개수가 N보다 작을 경우 cutLength를 앞의 절반에서 탐색한다.
// 7. 더 이상 탐색할 수 없는 경우 종료하고 cutLength를 리턴한다.

// * 조금 어이없게도 처음에 주어진 랜선을 버리면 안 된다고 착각해서 범위를 1부터 가장 짧은 랜선까지로 잡아 실패했다

public class BOJ1654_CuttingWire {
    static long[] wires;
    static long n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        wires = new long[k];
        for (int i = 0; i < k; i++) {
            wires[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(wires);
        System.out.println(bSearch(1, wires[k-1]));
    }

    private static long bSearch(long low, long high) {
        // 종료 조건
        if(low > high) {
            return high;
        }
        long mid = (low+high)/2;
        long sum = 0;
        for(long wire : wires) {
            sum += wire / mid;
        }
        if(sum >= n) {
            return bSearch(mid+1, high);
        } else {
            return bSearch(low, mid-1);
        }
    }
}
