package sort;

import java.util.*;

/**
 * 1~4094个接口，有连续和不连续的接口可用，申请使用一个，正序排序
 * 560-570,20-25,34,56-98,101,103,120-156
 * 56
 */
public class VLANResourcePool {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        String[] numbers = s.nextLine().split(",");
        for(int i = 0;i<numbers.length;i++){
            int[] l  = new int[2];
            if(numbers[i].contains("-")){
                String[] count = numbers[i].split("-");
                l[0] = Integer.parseInt(count[0]);
                l[1] = Integer.parseInt(count[1]);
            }else {
                l[0] = l[1] = Integer.parseInt(numbers[i]);
            }
            list.add(l);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int target = Integer.parseInt(s.nextLine());
        StringBuffer sb = new StringBuffer();
        for(int[] re : list){
            if(target >= re[0] && target <= re[1]){
                if(re[0] < target-1){
                    sb.append(re[0] + "-" + (target-1));
                    sb.append(",");
                }else if(re[0] == target-1){
                    sb.append(re[0]);
                    sb.append(",");
                }
                if(re[1] > target+1){
                    sb.append((target+1) + "-" + re[1]);
                    sb.append(",");
                }else if(re[1] == target+1){
                    sb.append(re[1]);
                    sb.append(",");
                }
            }else {
                if(re[1] == re[0]){
                    sb.append(re[0]);
                }else {
                    sb.append(re[0] + "-" + re[1]);
                }
                sb.append(",");
            }
        }
        String result = sb.toString().substring(0,sb.length()-1);
        System.out.println(result);
    }
}
