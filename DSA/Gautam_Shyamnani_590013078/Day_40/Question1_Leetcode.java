class FrontMiddleBackQueue {

    Deque<Integer> front;
    Deque<Integer> back;

    public FrontMiddleBackQueue() {
        front = new ArrayDeque<>();
        back = new ArrayDeque<>();
    }

    private void balance(){
        if(front.size() > back.size() + 1){
            back.offerFirst(front.pollLast());
        }else if(front.size() < back.size()){
            front.offerLast(back.pollFirst());
        }
    }
    
    public void pushFront(int val) {
        front.offerFirst(val);
        balance();
    }
    
    public void pushMiddle(int val) {
        if(front.size() > back.size()){
            back.offerFirst(front.pollLast());
        }
        front.offerLast(val);
    }
    
    public void pushBack(int val) {
        back.offerLast(val);
        balance();
    }
    
    public int popFront() {
        if(front.isEmpty() && back.isEmpty()) return -1;

        int val;
        if(!front.isEmpty()){
            val = front.pollFirst();
        }else{
            val = back.pollFirst();
        }
        balance();
        return val;
    }
    
    public int popMiddle() {
        if(front.isEmpty() && back.isEmpty()) return -1;

        int val = front.pollLast();
        balance();
        return val;
    }
    
    public int popBack() {
        if(front.isEmpty() && back.isEmpty()) return -1;

        int val;
        if(!back.isEmpty()){
            val = back.pollLast();
        }else{
            val = front.pollLast();
        }
        balance();
        return val;
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