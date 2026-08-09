package Day_40;

import java.util.*;

public class d40question1_leetcode {
    private static LinkedList<Integer> q = new LinkedList<>();

    public static void pushFront(int x) {
        q.addFirst(x);
    }

    public static void pushMiddle(int x) {
        q.add(q.size() / 2, x);
    }

    public static void pushBack(int x) {
        q.addLast(x);
    }

    public static int popFront() {
        if (q.isEmpty()) return -1;
        return q.removeFirst();
    }

    public static int popMiddle() {
        if (q.isEmpty()) return -1;
        int i = (q.size() - 1) / 2;
        return q.remove(i);
    }

    public static int popBack() {
        if (q.isEmpty()) return -1;
        return q.removeLast();
    }

    public static void main(String[] args) {
        pushFront(1);
        pushBack(2);
        pushMiddle(3);
        System.out.println(popFront());
        System.out.println(popMiddle());
        System.out.println(popBack());
    }
}
