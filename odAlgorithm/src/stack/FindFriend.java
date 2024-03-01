package stack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://oj.algomooc.com/
 * od算法 2650
 * fly  2024/3/1
 */
public class FindFriend {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int allCount = Integer.parseInt(s.nextLine());
        int[] result = new int[allCount];
        String[] height = s.nextLine().split(" ");
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = allCount-1;i>=0;i--){
            int a = Integer.parseInt(height[i]);
            while (!stack.isEmpty()){
                if(a < stack.peek()[1]){
                    int[] target = new int[]{i,a};
                    result[i] = stack.peek()[0];
                    stack.push(target);
                    break;
                }else {
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i] = 0;
                stack.push(new int[]{i,a});
            }
        }
        String all = Arrays.stream(result).mapToObj(a -> String.valueOf(a)).collect(Collectors.joining(" "));
        System.out.println(all);
    }
}
