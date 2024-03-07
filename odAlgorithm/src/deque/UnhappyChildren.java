package deque;

import java.util.*;

/**
 * https://oj.algomooc.com/problem.php?id=2699
 * od 2699
 * 10
 *  5 12 1 17 3 18 14  8 26  7 24 19 16   9 14 17 10 25 16 20 25 0 9 13 2 15 21 21 26 24 20 23 8 7 10 22 18 13 19 4 23 1 4 22 0 15 12 5 3 2
 *
 * fly  2024/3/2
 */
public class UnhappyChildren {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = Integer.parseInt(s.nextLine());
        String[] children = s.nextLine().split(" ");
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int result = 0;
        int c = 0;
        for(int i = 0;i<children.length;i++){
            int a = Integer.parseInt(children[i]);
            if(map.containsKey(a)){
                if(map.get(a) == 1){
                    result++;
                }else {
                    boolean change = false;
                    while (!deque.isEmpty()){
                        int x = deque.pollFirst();
                        if(map.containsKey(x)){
                            change = true;
                            map.put(x,0);
                            break;
                        }
                    }
                    if(!change){
                        c--;
                    }
                }
                map.remove(a);
            }else {
                if(c < count){
                    map.put(a,0);
                    c++;
                }else {
                    map.put(a,1);
                    deque.addLast(a);
                }
            }
        }
        System.out.println(result);

    }
}
