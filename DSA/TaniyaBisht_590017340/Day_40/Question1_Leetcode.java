
class FrontMiddleBackQueue {
    Deque<Integer> q;
    public FrontMiddleBackQueue() {
        q = new LinkedList<>();
    }
    public void pushFront(int val) {
        q.addFirst(val);
    }
    public void pushMiddle(int val) {
        int mid = q.size() / 2;
        List<Integer> temp = new ArrayList<>(q);
        temp.add(mid, val);
        q.clear();
        q.addAll(temp);
    }
    public void pushBack(int val) {
        q.addLast(val);
    }
    public int popFront() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.removeFirst();
    }
    public int popMiddle() {
        if (q.isEmpty()) {
            return -1;
        }
        int mid = (q.size() - 1) / 2;
        List<Integer> temp = new ArrayList<>(q);
        int value = temp.remove(mid);
        q.clear();
        q.addAll(temp);
        return value;
    }
    public int popBack() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.removeLast();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */