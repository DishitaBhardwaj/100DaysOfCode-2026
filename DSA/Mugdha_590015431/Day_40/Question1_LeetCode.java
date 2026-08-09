package DSA.Mugdha_590015431.Day_40;

import java.util.*;

public class Question1_LeetCode {

    static class FrontMiddleBackQueue {

        LinkedList<Integer> list;

        public FrontMiddleBackQueue() {
            list = new LinkedList<>();
        }

        public void pushFront(int val) {
            list.addFirst(val);
        }

        public void pushMiddle(int val) {
            int index = list.size() / 2;
            list.add(index, val);
        }

        public void pushBack(int val) {
            list.addLast(val);
        }

        public int popFront() {
            if (list.isEmpty())
                return -1;

            return list.removeFirst();
        }

        public int popMiddle() {
            if (list.isEmpty())
                return -1;

            int index = (list.size() - 1) / 2;
            return list.remove(index);
        }

        public int popBack() {
            if (list.isEmpty())
                return -1;

            return list.removeLast();
        }
    }

    public static void main(String[] args) {

        FrontMiddleBackQueue q = new FrontMiddleBackQueue();

        q.pushFront(1);
        q.pushBack(2);
        q.pushMiddle(3);
        q.pushMiddle(4);

        System.out.println(q.popFront());   // 1
        System.out.println(q.popMiddle());  // 3
        System.out.println(q.popMiddle());  // 4
        System.out.println(q.popBack());    // 2
        System.out.println(q.popFront());   // -1
    }
}