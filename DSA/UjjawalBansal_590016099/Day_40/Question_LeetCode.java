class FrontMiddleBackQueue {

    private class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private Node mid;
    private int size;

    public FrontMiddleBackQueue() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        
        mid = null;
        size = 0;
    }

    private void insertBetween(Node a, Node b, Node newNode) {
        a.next = newNode;
        newNode.prev = a;
        newNode.next = b;
        b.prev = newNode;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void pushFront(int val) {
        Node newNode = new Node(val);
        insertBetween(head, head.next, newNode);
        
        if (size == 0) {
            mid = newNode;
        } 
        else if (size % 2 == 1) {
            mid = mid.prev;
        }
        size++;
    }

    public void pushMiddle(int val) {
        Node newNode = new Node(val);
        
        if (size == 0) {
            insertBetween(head, tail, newNode);
            mid = newNode;
        } 
        else if (size % 2 == 1) {
            insertBetween(mid.prev, mid, newNode);
            mid = newNode;
        } 
        else {
            insertBetween(mid, mid.next, newNode);
            mid = newNode;
        }
        size++;
    }

    public void pushBack(int val) {
        Node newNode = new Node(val);
        insertBetween(tail.prev, tail, newNode);
        
        if (size == 0) {
            mid = newNode;
        } 
        else if (size % 2 == 0) {
            mid = mid.next;
        }
        size++;
    }

    public int popFront() {
        if (size == 0) return -1;
        
        Node target = head.next;
        int val = target.val;
        removeNode(target);
        
        if (size == 1) {
            mid = null;
        } 
        else if (size % 2 == 0) {
            mid = mid.next;
        }
        size--;
        
        return val;
    }

    public int popMiddle() {
        if (size == 0) return -1;
        
        int val = mid.val;
        Node nextMid;
        
        if (size == 1) {
            nextMid = null;
        } 
        else if (size % 2 == 0) {
            nextMid = mid.next;
        } 
        else {
            nextMid = mid.prev;
        }
        
        removeNode(mid);
        mid = nextMid;
        size--;
        
        return val;
    }

    public int popBack() {
        if (size == 0) return -1;
        
        Node target = tail.prev;
        int val = target.val;
        removeNode(target);
        
        if (size == 1) {
            mid = null;
        } 
        else if (size % 2 == 1) {
            mid = mid.prev;
        }
        size--;
        
        return val;
    }
}