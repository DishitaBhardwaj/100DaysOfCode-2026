import java.util.ArrayDeque;
import java.util.Deque;

class FrontMiddleBackQueue {
    private Deque<Integer> left;
    private Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        left.addFirst(val);
        if (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }
    }

    public void pushMiddle(int val) {
        if (left.size() < right.size()) {
            left.addLast(val);
        } 
        else {
            right.addFirst(val);
        }
    }

    public void pushBack(int val) {
        right.addLast(val);
        if (right.size() > left.size() + 1) {
            left.addLast(right.removeFirst());
        }
    }

    public int popFront() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }
        
        int val;
        if (left.isEmpty()) {
            val = right.removeFirst();
        } else {
            val = left.removeFirst();
            if (right.size() > left.size() + 1) {
                left.addLast(right.removeFirst());
            }
        }
        
        return val;
    }

    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }
        
        int val;
        if (left.size() == right.size()) {
            val = left.removeLast();
        } 
        else {
            val = right.removeFirst();
        }
        
        return val;
    }

    public int popBack() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }
        
        int val = right.removeLast();
        if (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }
        
        return val;
    }
}