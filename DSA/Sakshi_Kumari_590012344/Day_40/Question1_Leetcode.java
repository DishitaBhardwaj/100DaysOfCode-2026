import java.util.*;

class FrontMiddleBackQueue {

    Deque<Integer> first;
    Deque<Integer> second;

    public FrontMiddleBackQueue() {
        first = new ArrayDeque<>();
        second = new ArrayDeque<>();
    }

    private void fix() {
        while (first.size() > second.size() + 1) {
            second.addFirst(first.removeLast());
        }

        while (first.size() < second.size()) {
            first.addLast(second.removeFirst());
        }
    }

    public void pushFront(int val) {
        first.addFirst(val);
        fix();
    }

    public void pushMiddle(int val) {
        if (first.size() > second.size()) {
            second.addFirst(first.removeLast());
        }
        first.addLast(val);
    }

    public void pushBack(int val) {
        second.addLast(val);
        fix();
    }

    public int popFront() {
        if (first.isEmpty() && second.isEmpty()) {
            return -1;
        }

        int x;
        if (!first.isEmpty()) {
            x = first.removeFirst();
        } else {
            x = second.removeFirst();
        }

        fix();
        return x;
    }

    public int popMiddle() {
        if (first.isEmpty()) {
            return -1;
        }

        int x = first.removeLast();
        fix();
        return x;
    }

    public int popBack() {
        if (first.isEmpty() && second.isEmpty()) {
            return -1;
        }

        int x;
        if (!second.isEmpty()) {
            x = second.removeLast();
        } else {
            x = first.removeLast();
        }

        fix();
        return x;
    }
}
