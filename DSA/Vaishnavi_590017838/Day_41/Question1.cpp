class MyCircularQueue {
public:
    vector<int> queue;
    int frontIndex;
    int rearIndex;
    int currentSize;
    int capacity;

    MyCircularQueue(int k) {
        capacity = k;
        queue.resize(k);
        frontIndex = 0;
        rearIndex = -1;
        currentSize = 0;
    }

    bool enQueue(int value) {
        if(isFull())
            return false;
        rearIndex = (rearIndex + 1) % capacity;
        queue[rearIndex] = value;
        currentSize++;
        return true;
    }

    bool deQueue() {
        if(isEmpty())
            return false;
        frontIndex = (frontIndex + 1) % capacity;
        currentSize--;
        return true;
    }

    int Front() {
        if(isEmpty())
            return -1;
        return queue[frontIndex];
    }

    int Rear() {
        if(isEmpty())
            return -1;
        return queue[rearIndex];
    }

    bool isEmpty() {
        return currentSize == 0;
    }

    bool isFull() {
        return currentSize == capacity;
    }
};
