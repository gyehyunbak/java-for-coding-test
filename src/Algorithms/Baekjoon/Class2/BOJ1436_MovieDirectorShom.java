package Algorithms.Baekjoon.Class2;

import java.util.Scanner;

public class BOJ1436_MovieDirectorShom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 브루트포스를 이용해 1씩 값을 증가하며 문자열에 '666'이 있는지 확인하는 방법이다
        String str;
        int cnt = 1;
        int i = 666;
        while(cnt != n) {
            i++;
            str = String.valueOf(i);
            if(str.contains("666")) cnt++;
        }

        System.out.println(i);
    }
}


// 666 1666 2666 3666 4666 5666 6660 6661 6662 6663 6664 6665 6666 6667 6668 6669 7666 ...
// 9666 10666 11666 12666 13666 14666 15666 16660 16661 16662 16663 16664 16665 16666 16667 ...
// 23666 24666 25666 26660 26661 26662 ... 26669 27666 28666 ... 35666 36660 36661 ... 36669 37666 ...
// 66600 66601 66602 66603 66604 ... 66699 70666 71666 72666 73666 74666 75666 76666 77666 78666 ...
