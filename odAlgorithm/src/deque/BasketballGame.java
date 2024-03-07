package deque;

import java.util.*;

/**
 * https://oj.algomooc.com/problem.php?id=2698#
 * od 2698
 * fly  2024/3/2
 */
public class BasketballGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] te = s.nextLine().split(",");
        String[] stu = s.nextLine().split(",");
        HashSet<Integer> set = new HashSet<>();
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int[] tes = Arrays.stream(te).mapToInt(Integer::valueOf).toArray();
        int[] stus = Arrays.stream(stu).mapToInt(Integer::valueOf).toArray();
        int index = 0;
        for(int target : stus){
            if(set.contains(target)){
                if(deque.peekFirst() == target){
                    deque.pollFirst();
                    sb.append("L");
                }else if(deque.peekLast() == target){
                    deque.pollLast();
                    sb.append("R");
                }else {
                    System.out.println("NO");
                    return;
                }
                set.remove(target);
            }else {
                while (index < tes.length && tes[index] != target){
                    deque.addLast(tes[index]);
                    set.add(tes[index]);
                    index++;
                }
                if(index == tes.length){
                    System.out.println("NO");
                    return;
                }
                if(tes[index] == target){
                    if(deque.isEmpty()){
                        sb.append("L");
                    }else {
                        sb.append("R");
                    }
                    index++;
                }
            }
        }
        System.out.println(sb);
    }
}
