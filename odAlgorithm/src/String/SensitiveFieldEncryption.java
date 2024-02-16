package String;

import java.util.Scanner;

/**
 * 描述：
 * 给定一个由多个命令字组成的命令字符串；
 *
 * 1. 字符串长度小于等于127字节，只包含大小写字母，数字，下划线和偶数个双引号
 *
 * 2. 命令字之间以一个或多个下划线_进行分割
 *
 * 3. 可以通过两个双引号""来标识包含下划线_的命令字或空命令字（仅包含两个双引号的命令字），双引号不会在命令字内部出现
 * 请对指定索引的敏感字段进行加密，替换为******（6 个*），
 * 并删除命令字前后多余的下划线_。 如果无法找到指定索引的命令字，输出字符串ERROR
 *
 * 输入：
 * 输入为两行 第一行为命令字索引K（从0开始） 第二行为命令字符串S
 *
 * 输出：
 * 输出处理后的命令字符串 如果无法找到指定索引的命令字，输出字符串ERROR
 *
 * 1
 * password_a12345678_timeout_100___jini___ini_"_"_jios
 *
 * password_******_timeout_100
 *
 * fly  2024/2/16
 */
public class SensitiveFieldEncryption {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String read = s.nextLine();
        int index = Integer.parseInt(s.nextLine());
        int count = 0;
        int isAdd = 0;
        char[] reads = read.toCharArray();
        StringBuilder sb = new StringBuilder();
        if(index == 0){
            sb.append("******");
        }
        for(int i = 0;i<reads.length;i++){
            if(reads[i] == '_'){
                if(isAdd % 2 == 1){
                    if(count != index){
                        sb.append(reads[i]);
                    }
                }else {
                    if(i-1>= 0 && reads[i-1] == '_'){
                        continue;
                    }else {
                        sb.append("_");
                        count++;
                        if(count == index){
                            sb.append("******");
                        }
                    }
                }
            }else if (reads[i] == '"'){
                isAdd ++;
                if(count != index){
                    sb.append(reads[i]);
                }
            }else {
                if(count == index){
                    continue;
                }else {
                    sb.append(reads[i]);
                }
            }
        }
        if(sb.charAt(sb.length()-1) == '_'){
            sb.deleteCharAt(sb.length()-1);
        }
        if(count < index){
            System.out.println("ERROR");
        }else {
            System.out.println(sb.toString());
        }
    }
}
