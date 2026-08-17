public class Question1_LeetCode {
    class MyCircularQueue {
        private int[] queue;
        private int head;
        private int tail;
        private int currSize;
        private int maxSize;

        public MyCircularQueue(int k) {
            this.maxSize = k;
            this.queue = new int[k];
            
            this.head = 0;
            this.tail = -1;
            this.currSize = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            tail = (tail + 1) % maxSize;
            queue[tail] = value;
            currSize++;
            
            return true;
        }
        
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            
            head = (head + 1) % maxSize;
            currSize--;
            
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[head];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return queue[tail];
        }

        public boolean isEmpty() {
            return currSize == 0;
        }

        public boolean isFull() {
            return currSize == maxSize;
        }
    }
}
