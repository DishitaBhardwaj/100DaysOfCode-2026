class MyCircularQueue {
    vector<int> q;
    int front, size, capacity;

public:
    MyCircularQueue(int k) {
        q.resize(k);
        front = 0;
        size = 0;
        capacity = k;
    }

    bool enQueue(int value) {
        if (isFull()) return false;

        q[(front + size) % capacity] = value;
        size++;
        return true;
    }

    bool deQueue() {
        if (isEmpty()) return false;

        front = (front + 1) % capacity;
        size--;
        return true;
    }

    int Front() {
        return isEmpty() ? -1 : q[front];
    }

    int Rear() {
        return isEmpty() ? -1 : q[(front + size - 1) % capacity];
    }

    bool isEmpty() {
        return size == 0;
    }

    bool isFull() {
        return size == capacity;
    }
};