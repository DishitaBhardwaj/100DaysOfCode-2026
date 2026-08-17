class MyCircularQueue {

    int[] q;
    int f;
    int r;
    int s;
    int c;

    public MyCircularQueue(int k) {
        q = new int[k];
        c = k;
        f = 0;
        r = -1;
        s = 0;
    }

    public boolean enQueue(int value) {

        if (isFull())
            return false;

        r = (r + 1) % c;
        q[r] = value;
        s++;

        return true;
    }

    public boolean deQueue() {

        if (isEmpty())
            return false;

        f = (f + 1) % c;
        s--;

        return true;
    }

    public int Front() {

        if (isEmpty())
            return -1;

        return q[f];
    }

    public int Rear() {

        if (isEmpty())
            return -1;

        return q[r];
    }

    public boolean isEmpty() {
        return s == 0;
    }

    public boolean isFull() {
        return s == c;
    }
}