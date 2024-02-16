package String;

import java.util.Scanner;

/**
 * 描述：
 *有一种简易压缩算法: 针对全部由小写英文字母组成的字符串，将其中连续超过两个相同字母的部分压缩为连续个数加该字母，其他部分保持原样不变。
 *
 * 例如: 字符串"aaabbccccd"经过压缩成为字符串"3abb4cd"。
 *
 * 请您编写解压函数，根据输入的字符串，判断其是否为合法压缩过的字符串若输入合法则输出解压缩后的字符串，否则输出字符串"!error"来报告错误。
 *
 * 输入：
 *输入一行，为一个ASCII字符串，长度不会超过100字符，用例保证输出的字符串长度也不会超过100字符。
 *4dff78d8d
 *
 * 输出：
 *ddddff
 *
 * 若判断输入为合法的经过压缩后的字符串，则输出压缩前的字符串若输入不合法，则输出字符串“!error”
 *
 *
 * fly  2024/2/16
 */
public class StringDecompression {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        char[] chars = input.toCharArray();
        if(Character.isDigit(chars[chars.length-1])){
            System.out.println("!error");
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder num = new StringBuilder();
        char last = chars[0];
        for(int i = 0;i<chars.length;i++){
            if(Character.isDigit(chars[i])){
                num.append(chars[i]);
            }else {
                if(!Character.isLowerCase(chars[i]) || (i >= 2 && chars[i] == chars[i-1] && Character.isDigit(chars[i-2])) ||
                        (i >= 2 && chars[i-1] == chars[i] && chars[i-2] == chars[i])){
                    System.out.println("!error");
                    return;
                }
                if((i >= 1 && Character.isDigit(chars[i-1]))){
                    int numbers = Integer.parseInt(num.toString());
                    if(chars[i] == last || numbers <= 2){
                        System.out.println("!error");
                        return;
                    }
                    for(int j = 0;j<numbers;j++){
                        sb.append(chars[i]);
                    }
                    last = chars[i];
                    num.delete(0,num.length());
                }else {
                    last = chars[i];
                    sb.append(chars[i]);
                }
            }
        }
        System.out.println(sb);
    }
}
