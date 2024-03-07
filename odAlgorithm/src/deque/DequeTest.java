package deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * fly  2024/3/2
 */
public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addFirst(2);
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
    }
}
