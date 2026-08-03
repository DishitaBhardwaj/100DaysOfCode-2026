import java.util.ArrayDeque;
import java.util.Deque;

public class Problem1_Leetcode {
}

class FrontMiddleBackQueue {
    private final Deque<Integer> left;
    private final Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }
        left.addLast(val);
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    public int popFront() {
        if (empty()) {
            return -1;
        }

        int value = left.removeFirst();
        balance();
        return value;
    }

    public int popMiddle() {
        if (empty()) {
            return -1;
        }

        int value = left.removeLast();
        balance();
        return value;
    }

    public int popBack() {
        if (empty()) {
            return -1;
        }

        int value;
        if (!right.isEmpty()) {
            value = right.removeLast();
        } else {
            value = left.removeLast();
        }

        balance();
        return value;
    }

    public boolean empty() {
        return left.isEmpty() && right.isEmpty();
    }

    private void balance() {
        if (left.size() < right.size()) {
            left.addLast(right.removeFirst());
        } else if (left.size() > right.size() + 1) {
            right.addFirst(left.removeLast());
        }
    }
}