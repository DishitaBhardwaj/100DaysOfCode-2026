package Day_41;

public class d41question1_leetcode {
    static class MyCircularQueue {
        private int[] data;
        private int front;
        private int count;
        private int cap;

        public MyCircularQueue(int k) {
            data = new int[k];
            front = 0;
            count = 0;
            cap = k;
        }

        public boolean enQueue(int x) {
            if (isFull()) return false;
            int idx = (front + count) % cap;
            data[idx] = x;
            count++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            front = (front + 1) % cap;
            count--;
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return data[front];
        }

        public int Rear() {
            if (isEmpty()) return -1;
            int idx = (front + count - 1) % cap;
            return data[idx];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == cap;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue q = new MyCircularQueue(3);
        System.out.println(q.enQueue(1));
        System.out.println(q.enQueue(2));
        System.out.println(q.enQueue(3));
        System.out.println(q.enQueue(4));
        System.out.println(q.Rear());
        System.out.println(q.isFull());
        System.out.println(q.deQueue());
        System.out.println(q.enQueue(4));
        System.out.println(q.Rear());
    }
}
