package Algorithms.Baekjoon.Class1;
import java.util.*;

public class NumberOfWords_1152 {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        int count;

        if(arr[0].equals(" ")) {
            count = arr.length - 1;
        } else {
            count = arr.length;
        }


        System.out.println(count);
        for(String i : arr) {
            System.out.println(i);
        }
    }
}
