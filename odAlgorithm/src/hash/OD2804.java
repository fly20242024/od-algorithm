package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * fly  2024/3/3
 */
public class OD2804 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = Integer.parseInt(s.nextLine());
        int[] numbers = new int[count];
        int max = -1;
        for(int i = 0;i<count;i++){
            int a = Integer.parseInt(s.nextLine());
            if(map.containsKey(a)){
                max = Math.max(max,i - map.get(a));
            }else {
                map.put(a,i);
            }
        }
        System.out.println(max);
    }
}
