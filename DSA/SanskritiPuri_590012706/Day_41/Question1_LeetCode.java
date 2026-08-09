class MyCircularQueue {
    private int[] data;
    private int front;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        data = new int[k];
        front = 0;
        count = 0;
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        int idx = (front + count) % capacity;
        data[idx] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        count--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return data[front];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        int idx = (front + count - 1) % capacity;
        return data[idx];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == capacity;
    }
}
