package String;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * fly  2024/2/16
 */
public class MockMessageQueue {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] messages = s.nextLine().split(" ");
        int[][] queue = new int[messages.length/2][2];
        for(int i = 0;i<queue.length;i++){
            queue[i][0] = Integer.parseInt(messages[i*2]);
            queue[i][1] = Integer.parseInt(messages[i*2 + 1]);
        }
        Arrays.sort(queue, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        String[] time = s.nextLine().split(" ");
        for(int i = 0;i<time.length/2;i++){
            StringBuilder sb = new StringBuilder();
            int begin = Integer.parseInt(time[i*2]);
            int end = Integer.parseInt(time[i*2 +1]);
            if(begin > queue[queue.length-1][0] || end <= queue[0][0]){
                System.out.println(-1);
                continue;
            }else {
                for(int j = 0;j<queue.length;j++){
                    if(queue[j][0] >= begin && queue[j][0] < end){
                        sb.append(queue[j][1]);
                        sb.append(" ");
                    }
                    if(queue[j][0] >= end){
                        break;
                    }
                }
            }
            if(sb.length() != 0){
                sb.deleteCharAt(sb.length()-1);
            }
            System.out.println(sb);
        }
    }
}
