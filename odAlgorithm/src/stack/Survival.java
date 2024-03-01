package stack;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://oj.algomooc.com/
 * od 2604
 * fly  2024/3/1
 */
public class Survival {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] targets = s.nextLine().split(" ");
        Deque<Integer> negative = new ArrayDeque<>();
        Deque<Integer> positive = new ArrayDeque<>();
        for(int i = 0;i<targets.length;i++){
            int t = Integer.parseInt(targets[i]);
            if(t > 0){
                positive.push(t);
            }else {
                t = Math.abs(t);
                while (!positive.isEmpty()){
                    int a = positive.pop();
                    if(a > t){
                        a = a - t;
                        t = 0;
                        positive.push(a);
                        break;
                    }else if (a == t){
                        t = 0;
                        break;
                    }else {
                        t = t - a;
                    }
                }
                if(t != 0){
                    negative.push(t);
                }
            }
        }
        System.out.println(negative.size() + positive.size());
    }
}
