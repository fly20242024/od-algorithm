package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://oj.algomooc.com/problem.php?id=2653
 * 2653: 【单调栈】2023B-阿里巴巴找黄金宝箱(4)
 * fly  2024/3/2
 */
public class AlibabaAndGold {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] tar = s.nextLine().split(",");
        int[] result = new int[tar.length];
        Arrays.fill(result,-1);
        Deque<int[]> stack = new ArrayDeque<>();
        int max = 0;
        for(int i = 0;i<tar.length*2;i++){
            int a = i % tar.length;
            int r = Integer.parseInt(tar[a]);
            while (!stack.isEmpty()){
                if(r <= stack.peek()[1]){
                    stack.push(new int[]{a,r});
                    break;
                }else {
                    int[] out = stack.pop();
                    result[out[0]] = r;
                }
            }
            if(stack.isEmpty()){
                stack.push(new int[]{a,r});
            }
            if(r == max && i > tar.length){
                break;
            }
            max = Math.max(max,r);
        }
        String sout = Arrays.stream(result).mapToObj(a -> String.valueOf(a)).collect(Collectors.joining(","));
        System.out.println(sout);
    }
}
