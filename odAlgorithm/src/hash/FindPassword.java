package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * fly  2024/3/3
 */
public class FindPassword {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] passwords = s.nextLine().split(" ");
        HashSet<String> set = new HashSet<>();
        Arrays.sort(passwords);
        String target = " ";
        for(int i = 0;i<passwords.length;i++){
            if(passwords[i].length() == 1){
                set.add(passwords[i]);
                target = passwords[i];
            }else {
                String t = passwords[i].substring(0,passwords[i].length()-1);
                if(set.contains(t)){
                    set.add(passwords[i]);
                    target = passwords[i];
                }
            }
        }
        System.out.println(target);
    }
}
