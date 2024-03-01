package stack;

import com.sun.xml.internal.ws.resources.UtilMessages;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

/**
 * fly  2024/2/28
 */
public class StringDecompression {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] rels = s.nextLine().toCharArray();
        Deque<String> queue = new ArrayDeque<>();
        int i =0;
        String target = "";
        StringBuilder mu = new StringBuilder();
        while (i<rels.length){
            if(rels[i] == '{'){
                queue.push("{");
                i++;
            }else if(rels[i] == '}'){
                while (!queue.peek().equals("{")){
                    target = queue.pop() + target;
                }
                queue.pop();
                queue.push(target);
                target = "";
                i++;
            }else if(Character.isDigit(rels[i])){
                if(mu.length() != 0){
                    queue.push(mu.toString());
                    mu.delete(0,mu.length());
                }
                StringBuilder sb = new StringBuilder();
                while (i < rels.length && Character.isDigit(rels[i])){
                    sb.append(rels[i]);
                    i++;
                }
                int count = Integer.parseInt(sb.toString());
                String str = queue.pop();
                StringBuilder ij = new StringBuilder();
                for(int j = 0;j<count;j++){
                    ij.append(str);
                }
                queue.push(ij.toString());
            }else {
                queue.push(String.valueOf(rels[i]));
                i++;
            }
        }
        String result = "";
        while (queue.size() != 0){
            result = queue.pop() + result;
        }
        System.out.println(result);
    }
}
