package pointer;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * fly  2024/3/3
 */
public class OD3003 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] numbers = s.nextLine().split(" ");
        int[] nums = Arrays.stream(numbers).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(nums);
        int a = 0;
        int b = nums.length-1;
        int min = Integer.MAX_VALUE;
        int x = 0;
        int y = 0;
        while (a < b){
            int c = nums[a] + nums[b];
            if(Math.abs(c) < min){
                min = Math.abs(c);
                x = a;
                y = b;
            }
            if(Math.abs(nums[a+1] + nums[b]) < Math.abs(nums[a] + nums[b-1])){
                a++;
            }else {
                b--;
            }
        }
        System.out.println(nums[x] + " " + nums[y] + " " + min);
    }
}
