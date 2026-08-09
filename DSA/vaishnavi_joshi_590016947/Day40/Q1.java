import java.util.*;

class FrontMiddleBackQueue {

    LinkedList<Integer> left;
    LinkedList<Integer> right;

    public FrontMiddleBackQueue() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    private void balance() {
        if (left.size() > right.size() + 1) {
            right.addFirst(left.removeLast());
        } else if (left.size() < right.size()) {
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
        balance();
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    public int popFront() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }

        int ans;
        if (!left.isEmpty()) {
            ans = left.removeFirst();
        } else {
            ans = right.removeFirst();
        }

        balance();
        return ans;
    }

    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }

        int ans = left.removeLast();
        balance();
        return ans;
    }

    public int popBack() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }

        int ans;
        if (!right.isEmpty()) {
            ans = right.removeLast();
        } else {
            ans = left.removeLast();
        }

        balance();
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

        FrontMiddleBackQueue q = new FrontMiddleBackQueue();

        System.out.println("pushFront(1)");
        q.pushFront(1);

        System.out.println("pushBack(2)");
        q.pushBack(2);

        System.out.println("pushMiddle(3)");
        q.pushMiddle(3);

        System.out.println("pushMiddle(4)");
        q.pushMiddle(4);

        System.out.println("popFront = " + q.popFront());

        System.out.println("popMiddle = " + q.popMiddle());

        System.out.println("popMiddle = " + q.popMiddle());

        System.out.println("popBack = " + q.popBack());

        System.out.println("popFront = " + q.popFront());
    }
}