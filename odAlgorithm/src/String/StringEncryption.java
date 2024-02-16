package String;

import java.util.Scanner;

/**
 * 描述：
 * 给你一串末加密的字符串str，通过对字符串的每一个字母进行改变来实现加密，加密方式是在每一字母str[i]偏移特定数组元素a[i]的量，数组a前三位已经赋值：a[0]=1,a[1]=2,a[2]=4。
 *当i>=3时，数组元素a[i]=a[i-1]+a[i-2]+a[i-3]。
 *例如: 原文 abcde 加密后 bdgkr，其中偏移量分别是1,2,4,7,13。
 *
 *
 * 输入：第一行为一个整数n (1 <= n <= 1000) ，表示有n组测试数据，每组数据包含一行，原文str(只含有小写字母，0 < 长度 <= 50)。
 *
 *
 * 输出：每组测试数据输出一行，表示字符串的密文
 *
 * fly  2024/2/16
 */
public class StringEncryption {

    public static int[] count = new int[50];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] chars = new char[26];
        for(int i = 0;i<26;i++){
            chars[i] = (char) ('a' + i);
        }
        int number = Integer.parseInt(s.nextLine());
        count[0] = 1;
        count[1] = 2;
        count[2] = 4;
        for(int i = 0;i<number;i++){
            String target = s.nextLine();
            System.out.println(encryption(target,chars));
        }
    }

    public static String encryption(String target,char[] chars){
        char[] rel = target.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<rel.length;i++){
            if(count[i] == 0){
                count[i] = count[i-1] + count[i-2] + count[i-3];
            }
            long p = ((rel[i] - 'a') + count[i]) % 26;
            sb.append(chars[(int)p]);
        }
        return sb.toString();
    }
}
