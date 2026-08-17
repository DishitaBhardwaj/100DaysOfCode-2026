public class Question1_LeetCode {
    
}
/**
 * LeetCode 1670 - Design Front Middle Back Queue
 * https://leetcode.com/problems/design-front-middle-back-queue/
 */

//Need to support insertion and deletion from front, middle and back

import java.util.*;

class FrontMiddleBackQueue {

    private LinkedList<Integer> list;

    public FrontMiddleBackQueue() {
        list = new LinkedList<>();
    }

    public void pushFront(int val) {
        list.addFirst(val);
    }

    public void pushMiddle(int val) {
        list.add(list.size() / 2, val);
    }

    public void pushBack(int val) {
        list.addLast(val);
    }

    public int popFront() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.removeFirst();
    }

    public int popMiddle() {
        if (list.isEmpty()) {
            return -1;
        }

        int index = (list.size() - 1) / 2;
        return list.remove(index);
    }

    public int popBack() {
        if (list.isEmpty()) {
            return -1;
        }
        return list.removeLast();
    }
}