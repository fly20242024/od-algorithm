package avarice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * fly  2024/3/3
 */
public class OD3117 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = Integer.parseInt(s.nextLine());
        String[] p = s.nextLine().split(" ");
        int av = Integer.parseInt(s.nextLine());
        int[] ps = Arrays.stream(p).mapToInt(Integer::valueOf).sorted().toArray();
        int a = 0;
        int b = ps.length-1;
        int result = 0;
        if(ps[0] >= av){
            System.out.println(ps.length);
            return;
        }
        while (a < b){
            if(ps[b] >= av){
                result++;
                b--;
            }else{
                if(ps[b] + ps[a] >= av){
                    result++;
                    b--;
                    a++;
                }else {
                    if(ps[a+1] + ps[b] > ps[a] + ps[b-1]){
                        a++;
                    }else {
                        b--;
                    }
                }
            }
        }
        if(ps[a] >= av){
            result++;
        }
        System.out.println(result);
    }
}
