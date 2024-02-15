package sort;


import java.util.*;

/**
 *给定一个乱序的数组，删除所有的重复元素，使得每个元素只出现一次，
 * 并且按照出现的次数从高到低进行排序，相同出现次数按照第一次出现顺序进行先后排序。
 *
 * 1,3,3,3,2,4,4,4,5
 */
public class ArrayDeduplication {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] num = s.nextLine().split(",");
        HashMap<Integer,Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        int count = 0;
        for(int i = 0;i<num.length;i++){
            int target = Integer.parseInt(num[i]);
            if(map.containsKey(target)){
                int[] rel = list.get(map.get(target));
                rel[1] = rel[1]+1;
                list.set(map.get(target),rel);
            }else {
                map.put(target,count);
                list.add(new int[]{target,1});
                count++;
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for(int i = 0;i<list.size();i++){
            System.out.print(list.get(i)[0]);
            if(i != list.size()-1){
                System.out.print(",");
            }
        }
    }
}
