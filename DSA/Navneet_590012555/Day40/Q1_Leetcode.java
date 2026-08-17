class FrontMiddleBackQueue {

    Deque<Integer> left;
    Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    private void balance() {
        if (left.size() > right.size() + 1)
            right.addFirst(left.removeLast());
        else if (left.size() < right.size())
            left.addLast(right.removeFirst());
    }

    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() > right.size())
            right.addFirst(left.removeLast());

        left.addLast(val);
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    public int popFront() {
        if (left.isEmpty() && right.isEmpty())
            return -1;

        int x = !left.isEmpty() ? left.removeFirst() : right.removeFirst();
        balance();
        return x;
    }

    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty())
            return -1;

        int x = left.removeLast();
        balance();
        return x;
    }

    public int popBack() {
        if (left.isEmpty() && right.isEmpty())
            return -1;

        int x = !right.isEmpty() ? right.removeLast() : left.removeLast();
        balance();
        return x;
    }
}