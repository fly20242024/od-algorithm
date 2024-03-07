package bianrysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * fly  2024/3/4
 */
public class OD3304 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] cake = s.nextLine().split(",");
        int[] gift = Arrays.stream(s.nextLine().split(",")).mapToInt(Integer::valueOf).sorted().toArray();
        int all = Integer.valueOf(s.nextLine());
        int max = 0;
        for(int i = 0;i<cake.length;i++){
            int a = Integer.valueOf(cake[i]);
            if(a >= all){
                continue;
            }else {
                int b = all - a;
                int c = binarySearch(gift,b);
                max += c;
            }
        }
        System.out.println(max);
    }
    public static int binarySearch(int[] gift,int b){
        int left = 0;
        int right = gift.length;
        while (left < right){
            int mid = left + (right - left)/2;
            if(gift[mid] <= b){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
