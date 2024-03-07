package hash;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * https://oj.algomooc.com/problem.php?id=2702#
 * od 2702
 * fly  2024/3/2
 */
public class RandomMing {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        Scanner s = new Scanner(System.in);
        int count = Integer.parseInt(s.nextLine());
        while (count>0){
            int a = Integer.parseInt(s.nextLine());
            set.add(a);
            count--;
        }
        for(int b : set){
            System.out.println(b);
        }
    }
}
