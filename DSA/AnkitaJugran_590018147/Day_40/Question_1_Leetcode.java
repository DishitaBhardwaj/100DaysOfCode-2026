class FrontMiddleBackQueue {

    Deque<Integer> left;
    Deque<Integer> right;

    public FrontMiddleBackQueue() {

        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }
    
    public void pushFront(int val) {

        left.addFirst(val);
        balance();
        
    }
    
    public void pushMiddle(int val) {

        if ( left.size() > right.size() ) {

            right.addFirst(left.pollLast());
        }
        left.addLast(val);
        
    }
    
    public void pushBack(int val) {

        right.addLast(val);
        balance();   
    }
    
    public int popFront() {

        if ( left.isEmpty() && right.isEmpty() ) {
            return -1;
        }
        int ans;
        if ( !left.isEmpty() ) {
            ans = left.pollFirst();
        } 
        else {
            ans = right.pollFirst();
        }

        balance();
        return ans;
    }
    
    public int popMiddle() {

        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }

        int ans = left.pollLast();
        balance();
        return ans;        
    }
    
    public int popBack() {

        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }

        int ans;
        if (!right.isEmpty()) {
            ans = right.pollLast();
        } else {
            ans = left.pollLast();
        }

        balance();
        return ans;        
        
    }

    private void balance() {

        //left should never have one more element then right
        if ( left.size() > right.size() + 1 ){
            
            //add the last element of left at the front of right
            right.addFirst(left.pollLast());
        }
        // Right should never have more elements than Left.
        else if (right.size() > left.size()) {
            left.addLast(right.pollFirst());
        }
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