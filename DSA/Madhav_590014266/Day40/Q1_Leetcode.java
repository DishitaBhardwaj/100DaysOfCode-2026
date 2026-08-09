class FrontMiddleBackQueue {

    private Deque<Integer> frontHalf = new ArrayDeque<>();
    private Deque<Integer> backHalf = new ArrayDeque<>();


    public FrontMiddleBackQueue() {
    }

    public void pushFront(int val) {
        frontHalf.offerFirst(val);
        rebalance();
    }

    
    public void pushMiddle(int val) {
        frontHalf.offerLast(val);
        rebalance();
    }

    
    public void pushBack(int val) {
        backHalf.offerLast(val);
        rebalance();
    }

    
    public int popFront() {
        if (frontHalf.isEmpty() && backHalf.isEmpty()) {
            return -1;
        }
  
        int value = frontHalf.isEmpty() ? backHalf.pollFirst() : frontHalf.pollFirst();
        rebalance();
        return value;
    }

    public int popMiddle() {
        if (frontHalf.isEmpty() && backHalf.isEmpty()) {
            return -1;
        }
      
        int value = frontHalf.size() == backHalf.size() ? 
                    frontHalf.pollLast() : backHalf.pollFirst();
        rebalance();
        return value;
    }

    
    public int popBack() {
        if (backHalf.isEmpty()) {
            return -1;
        }
      
        int value = backHalf.pollLast();
        rebalance();
        return value;
    }

    
    private void rebalance() {
        // If front half has more elements, move one to back half
        if (frontHalf.size() > backHalf.size()) {
            backHalf.offerFirst(frontHalf.pollLast());
        }
        // If back half has more than one extra element, move one to front half
        if (backHalf.size() > frontHalf.size() + 1) {
            frontHalf.offerLast(backHalf.pollFirst());
        }
    }
}

