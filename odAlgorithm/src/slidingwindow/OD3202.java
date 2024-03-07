package slidingwindow;

import java.util.Arrays;
import java.util.Scanner;

/**
 * fly  2024/3/3
 */
public class OD3202 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int all = Integer.parseInt(s.nextLine());
        int[] count = Arrays.stream(s.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int x = 0;
        int y = 0;
        int max = 0;
        int add = 0;
        while (y < count.length){
            add += count[y];
            while (add > all){
                add -= count[x];
                x++;
            }
            max = Math.max(add,max);
            y++;
        }
        System.out.println(max);
    }
}
