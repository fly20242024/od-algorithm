package String;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * 描述：
 * 让我们来模拟一个消息队列的运作，有一个发布者和若干消费者，发布者会在给定的时刻向消息队列发送消息：
 *
 * 1. 若此时消息队列有消费者订阅，这个消息会被发送到订阅的消费者中优先级最高（输入中消费者按优先级升序排列）的一个；
 *
 * 2. 若此时没有订阅的消费者，该消息被消息队列丢弃。
 *
 * 消费者则会在给定的时刻订阅消息队列或取消订阅。
 *
 * 1. 当消息发送和订阅发生在同一时刻时，先处理订阅操作，即同一时刻订阅的消费者成为消息发送的候选。
 *
 * 2. 当消息发送和取消订阅发生在同一时刻时，先处理取消订阅操作，即消息不会被发送到同一时刻取消订阅的消费者。
 *
 * 输入：
 * 输入为两行。
 * 		第一行为2N个正整数，代表发布者发送的N个消息的时刻和内容（为方便解折，消息内容也用正整数表示）。
 * 		第一个数字是第一个消息的发送时刻，第二个数字是第一个消息的内容，以此类推。用例保证发送时刻不会重复，但注意消息并没有按照发送时刻排列。
 * 		第二行为2M个正整数，代表M个消费者订阅和取消订阅的时刻。
 * 		第一个数字是第一个消费者订阅的时刻，第二个数字是第一个消费者取消订阅的时刻，以此类推。
 * 		用例保证每个消费者的取消订阅时刻大于订阅时刻，消费者按优先级升序排列。
 * 		两行的数字都由空格分隔。N不超过100，M不超过10，每行的长度不超过1000字符。
 *2 22 1 11 4 44 5 55 3 33
 * 1 7 2 3
 *
 * 输出：
 * 		输出为M行，依次为M个消费者收到的消息内容，消息内容按收到的顺序排列，且由空格分隔；
 * 		若某个消费者没有收到任何消息，则对应的行输出-1.
 *
 * 	11 33 44 55
 * 22
 *
 * fly  2024/2/16
 */
public class MockMessageQueue {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] messages = s.nextLine().split(" ");
        List<List<Integer>> queue = new ArrayList<>();
        for(int i = 0;i<messages.length;i = i+2){
            int a = Integer.parseInt(messages[i]);
            int b = Integer.parseInt(messages[i+1]);
            queue.add(Arrays.asList(a,b));
        }
        queue.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        String[] times = s.nextLine().split(" ");
        List<List<Integer>> time = new ArrayList<>();
        for(int i = 0;i<times.length;i = i+2){
            int a = Integer.parseInt(times[i]);
            int b = Integer.parseInt(times[i+1]);
            time.add(Arrays.asList(a,b));
        }
        List<Integer>[] res = new List[time.size()];
        for(int i = 0;i<res.length;i++){
            res[i] = new ArrayList<>();
        }
        for(int i = 0;i<queue.size();i++){
            int j = time.size()-1;
            while (j >= 0){
                if(queue.get(i).get(0) >= time.get(j).get(0) &&
                        queue.get(i).get(0) < time.get(j).get(1)){
                    res[j].add(queue.get(i).get(1));
                    break;
                }
                j--;
            }
        }
        for(int i = 0;i<res.length;i++){
            if(res[i].size() == 0){
                System.out.println(-1);
            }else {
                String result = res[i].stream().map(Object::toString).collect(Collectors.joining(" "));
                System.out.println(result);
            }
        }
    }
}
