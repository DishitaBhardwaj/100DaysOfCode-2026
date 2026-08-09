import java.util.*;

class FrontMiddleBackQueue {

    Deque<Integer> left;
    Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    private void balance() {

        if (left.size() > right.size() + 1) {
            right.offerFirst(left.pollLast());
        } else if (left.size() < right.size()) {
            left.offerLast(right.pollFirst());
        }
    }

    public void pushFront(int val) {
        left.offerFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        }
        left.offerLast(val);
    }

    public void pushBack(int val) {
        right.offerLast(val);
        balance();
    }

    public int popFront() {
        if (left.isEmpty() && right.isEmpty())
            return -1;

        int ans;
        if (!left.isEmpty())
            ans = left.pollFirst();
        else
            ans = right.pollFirst();

        balance();
        return ans;
    }

    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty())
            return -1;

        int ans = left.pollLast();
        balance();
        return ans;
    }

    public int popBack() {
        if (left.isEmpty() && right.isEmpty())
            return -1;

        int ans;
        if (!right.isEmpty())
            ans = right.pollLast();
        else
            ans = left.pollLast();

        balance();
        return ans;
    }
}