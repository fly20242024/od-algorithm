package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * https://oj.algomooc.com/
 * od算法 2603
 * fly  2024/3/1
 */
public class LISPOperation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        input = input.replaceAll("\\("," ( ");
        input = input.replaceAll("\\)"," ) ");
        String[] target = input.split(" ");
        Deque<String> deque = new ArrayDeque<>();
        for(int i = 0;i<target.length;i++){
            if(target[i].equals("(") || target[i].equals("")){
                continue;
            }else if(target[i].equals(")")){
                int a = Integer.valueOf(deque.pop());
                int b = Integer.valueOf(deque.pop());
                int c = 0;
                String op = deque.pop();
                if(op.equals("div")){
                    if(a == 0){
                        System.out.println("error");
                        return;
                    }
                    c = Math.floorDiv(b,a);
                }else if(op.equals("mul")){
                    c = a * b;
                }else if(op.equals("add")){
                    c = a +b;
                }else {
                    c = b - a;
                }
                deque.push(String.valueOf(c));
            }else {
                deque.push(target[i]);
            }
        }
        System.out.println(deque.peek());
    }
}
