package String;

import java.util.Scanner;

/**
 *    输入一个单词前缀和一个字典，输出包含该前缀的单词。
 *
 *       单词前缀+字典长度+字典。字典是一个有序单词数组。输入输出都是小写
 *
 *       所有包含该前缀的单词，多个单词换行输出
 * 		若没有则返回-1
 *
 *
 */
public class Dictionary {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String target = s.next();
        int number = s.nextInt();
        int count = 0;
        for(int i = 0;i<number;i++){
            String read = s.next();
            if(target.length() > read.length()){
                continue;
            }
            if(target.equals(read.substring(0,target.length()))){
                System.out.println(read);
                count++;
            }
        }
        if(count == 0){
            System.out.println(-1);
        }
    }
}
