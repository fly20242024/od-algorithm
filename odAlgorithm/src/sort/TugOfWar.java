package sort;

import java.util.*;

/**
 * 按照身高优先 体重次优先的规则选出10个人
 * 181 70
 * 182 70
 * 183 70
 * 184 70
 * 185 70
 * 186 70
 * 180 71
 * 180 72
 * 180 73
 * 180 74
 * 180 75
 */
public class TugOfWar {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        while (s.hasNext()){
            String[] people = s.nextLine().split(" ");
            int[] employee = new int[2];
            employee[0] = Integer.parseInt(people[0]);
            employee[1] = Integer.parseInt(people[1]);
            list.add(employee);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]){
                    return b[1] - a[1];
                }else {
                    return b[0] - a[0];
                }
            }
        });
        for(int i = 0;i<10;i++){
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
        }
    }
}
