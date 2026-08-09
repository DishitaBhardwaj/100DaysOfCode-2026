import java.util.ArrayDeque;
import java.util.Deque;

class FrontMiddleBackQueue {

    Deque<Integer> left;
    Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    private void balance() {

        if (left.size() > right.size() + 1) {
            right.addFirst(left.removeLast());
        }

        if (left.size() < right.size()) {
            left.addLast(right.removeFirst());
        }
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

        if (left.isEmpty() && right.isEmpty())
            return -1;

        int ans = left.removeFirst();
        balance();
        return ans;
    }

    public int popMiddle() {

        if (left.isEmpty() && right.isEmpty())
            return -1;

        int ans = left.removeLast();
        balance();
        return ans;
    }

    public int popBack() {

        if (left.isEmpty() && right.isEmpty())
            return -1;

        int ans;

        if (!right.isEmpty())
            ans = right.removeLast();
        else
            ans = left.removeLast();

        balance();

        return ans;
    }
}