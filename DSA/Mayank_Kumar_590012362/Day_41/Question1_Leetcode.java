class MyCircularQueue {
    int[] a;
    int f, r, s, n;
    public MyCircularQueue(int k) {
        a = new int[k];
        f = 0; r = 0; s = 0; n = k;
    }
    public boolean enQueue(int v) {
        if (isFull()) return false;
        a[r] = v; r = (r + 1) % n; s++;
        return true;
    }
    public boolean deQueue() {
        if (isEmpty()) return false;
        f = (f + 1) % n; s--;
        return true;
    }
    public int Front() {
        if (isEmpty()) return -1;
        return a[f];
    }
    public int Rear() {
        if (isEmpty()) return -1;
        return a[(r - 1 + n) % n];
    }
    public boolean isEmpty() {
        return s == 0;
    }
    public boolean isFull() {
        return s == n;
    }
}