class MyCircularQueue {
int f=0,r=0,s=0; 
int[] q;
    public MyCircularQueue(int k) {
        q=new int[k];
        Arrays.fill(q,-1);
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            f=r=0;
            q[r]=value;
            s++;
            return true;
        }
        r++;
        s++;
        r=r%q.length;
        q[r]=value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        q[f]=-1;
        s--;
        f++;
        f=f%q.length;
        return true;
    }
    
    public int Front() {
        return q[f];
    }
    
    public int Rear() {
        return q[r];
    }
    
    public boolean isEmpty() {
        return s==0;
    }
    
    public boolean isFull() {
        return s==q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */