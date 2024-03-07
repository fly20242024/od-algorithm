package pointer;

import java.util.Scanner;

/**
 * fly  2024/3/3
 */
public class OD3002 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String r = s.nextLine();
        char[] chars = r.toCharArray();
        int a = 0;
        int max = 0;
        while (a < chars.length){
            if(isTarget(chars[a])){
                int b = a + 1;
                while (b < chars.length){
                    if(isTarget(chars[b])){
                        b++;
                    }else {
                        break;
                    }
                }
                max = Math.max(b -a,max);
                a = b;
            }else {
                a++;
            }
        }
        System.out.println(max);
    }

    public static boolean isTarget(char c){
        c = Character.toLowerCase(c);
        if( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }else {
            return false;
        }

    }
}
