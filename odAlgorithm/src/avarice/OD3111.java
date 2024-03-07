package avarice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * fly  2024/3/3
 */
public class OD3111 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = Integer.parseInt(s.nextLine());
        String[] aPeople = s.nextLine().split(" ");
        String[] bPeople = s.nextLine().split(" ");
        int[] a = Arrays.stream(aPeople).mapToInt(Integer::valueOf).sorted().toArray();
        int[] b = Arrays.stream(bPeople).mapToInt(Integer::valueOf).sorted().toArray();
        int aL = 0;
        int bL = 0;
        int aR = count-1;
        int bR = count-1;
        int result = 0;
        while (aL <= aR){
            if(a[aR] > b[bR]){
                aR--;
                bR--;
                result++;
            }else if(a[aR] < b[bR]){
                bR--;
                aL++;
                result--;
            }else {
                if(a[aL] > b[bL]){
                    aL++;
                    bL++;
                    result++;
                }else {
                    if(a[aL] < b[bR]){
                        result--;
                    }
                    aL++;
                    bR--;
                }
            }
        }
        System.out.println(result);
    }
}
