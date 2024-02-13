package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *身高提供排序 序号1~n 排序规则：身高由低到高 身高相同体重由轻到重 输出排列后的序号
 * 6   人数
 * 100 100 120 80 160 160 身高
 * 60 50 70 40 50 60 体重
 *
 *
 * 
 * 4 2 1 3 5 6
 */
public class HeightRanking {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number = Integer.parseInt(s.nextLine());
        int[][] res = new int[number][3];
        int count = 1;
        while (count < 3){
            String[] strs = s.nextLine().split(" ");
            for(int i = 0;i<number;i++){
                if(count == 1){
                    res[i][0] = i+1;
                }
                res[i][count] = Integer.parseInt(strs[i]);
            }
            count++;
        }
        Arrays.sort(res,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1]){
                    return a[2] - b[2];
                }else{
                    return a[1] - b[1];
                }
            }
        });
        for(int i = 0;i<res.length;i++){
            System.out.print(res[i][0]);
            if(i != res.length-1){
                System.out.print(" ");
            }
        }
    }
}
