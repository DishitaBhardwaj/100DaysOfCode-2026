package DSA.Navneet_590012555.Day41;

public class MyCircularQueue {

    int[] q;
    int front, rear, size, k;

    public MyCircularQueue(int k) {
        this.k = k;
        q = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;

        rear = (rear + 1) % k;
        q[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;

        front = (front + 1) % k;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return q[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return q[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}{

}
