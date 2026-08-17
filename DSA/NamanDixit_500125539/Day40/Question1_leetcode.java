
import java.util.LinkedList;

class Question1_leetcode {

    LinkedList<Integer> queue;

    // Constructor
    public Question1_leetcode() {

        queue = new LinkedList<>();
    }

    // Insert at front
    public void pushFront(int val) {

        queue.addFirst(val);
    }

    // Insert at middle
    public void pushMiddle(int val) {

        int middle = queue.size() / 2;

        queue.add(middle, val);
    }

    // Insert at back
    public void pushBack(int val) {

        queue.addLast(val);
    }

    // Remove front
    public int popFront() {

        if (queue.isEmpty()) {
            return -1;
        }

        return queue.removeFirst();
    }

    // Remove middle
    public int popMiddle() {

        if (queue.isEmpty()) {
            return -1;
        }

        int middle = (queue.size() - 1) / 2;

        return queue.remove(middle);
    }

    // Remove back
    public int popBack() {

        if (queue.isEmpty()) {
            return -1;
        }

        return queue.removeLast();
    }
}
