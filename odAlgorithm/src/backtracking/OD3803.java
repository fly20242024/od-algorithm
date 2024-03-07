package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * fly  2024/3/4
 */
public class OD3803 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] tars = s.nextLine().split(",");
        int len = Integer.parseInt(s.nextLine());
        if(tars.length < len){
            System.out.println("None");
            return;
        }
        List<String> list = new ArrayList<>();
        int[] nums = Arrays.stream(tars).mapToInt(Integer::valueOf).sorted().toArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<nums.length;i++){
            sb.append(nums[i]);
            int count = 1;
            dfs(nums,i,list,sb,len,count);
            sb.deleteCharAt(sb.length()-1);
        }
        if(list.size()==0){
            System.out.println("None");
        }else {
            for(String str:list){
                System.out.println(str);
            }
        }
    }
    public static void dfs(int[] nums,int i,List<String> list,StringBuilder sb,int len,int count){
        if(count >= len){
            list.add(sb.toString());
        }
        for(int j = i+1;j<nums.length;j++){
            sb.append(",");
            sb.append(nums[j]);
            count++;
            dfs(nums,j,list,sb,len,count);
            sb.delete(sb.length()-2,sb.length());
            count--;
        }
    }
}
