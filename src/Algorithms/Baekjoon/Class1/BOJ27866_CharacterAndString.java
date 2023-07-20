package Algorithms.Baekjoon.Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ27866_CharacterAndString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(br.readLine().charAt(Integer.parseInt(br.readLine()) - 1));
        //Scanner sc = new Scanner(System.in);
        //System.out.println(sc.next().charAt(sc.nextInt() - 1));
    }
}
