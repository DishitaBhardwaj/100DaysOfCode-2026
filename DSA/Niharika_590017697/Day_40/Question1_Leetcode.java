class FrontMiddleBackQueue {
    Deque<Integer> left = new ArrayDeque<>();
    Deque<Integer> right = new ArrayDeque<>();

    public FrontMiddleBackQueue() {
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
        if (left.isEmpty() && right.isEmpty()) return -1;
        int val = !left.isEmpty() ? left.removeFirst() : right.removeFirst();
        balance();
        return val;
    }

    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty()) return -1;
        int val = left.removeLast();
        balance();
        return val;
    }

    public int popBack() {
        if (left.isEmpty() && right.isEmpty()) return -1;
        int val = !right.isEmpty() ? right.removeLast() : left.removeLast();
        balance();
        return val;
    }

    private void balance() {
        while (left.size() > right.size() + 1) {
            right.addFirst(left.removeLast());
        }
        while (right.size() > left.size()) {
            left.addLast(right.removeFirst());
        }
    }
}