package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 对数字的最低位正序排序
 * 1,2,5,-21,22,11,55,-101,42,8,7,32
 */
public class LowestOrder {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] strs = s.nextLine().split(",");
        int[][] numbers = new int[strs.length][2];
        for(int i = 0;i<strs.length;i++){
            numbers[i][1] = Integer.parseInt(strs[i]);
            numbers[i][0] = lowestNumber(Math.abs(numbers[i][1]));
        }
        Arrays.sort(numbers, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for(int i = 0;i<numbers.length;i++){
            System.out.print(numbers[i][1]);
            if(i != numbers.length-1){
                System.out.print(",");
            }
        }
    }

    public static int lowestNumber(int number){
        if(number < 10){
            return number;
        }
        return lowestNumber(number % 10);
    }
}
