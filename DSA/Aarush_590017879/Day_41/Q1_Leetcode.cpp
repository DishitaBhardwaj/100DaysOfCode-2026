#include <iostream>
#include <vector>
using namespace std;

class MyCircularQueue {
private:
    vector<int> queue;
    int front;
    int rear;
    int size;
    int capacity;

public:
    MyCircularQueue(int k) {
        capacity = k;
        queue.resize(k);
        front = 0;
        rear = -1;
        size = 0;
    }

    bool enQueue(int value) {
        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;

        return true;
    }

    bool deQueue() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    int Front() {
        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return queue[rear];
    }

    bool isEmpty() {
        return size == 0;
    }

    bool isFull() {
        return size == capacity;
    }
};

int main() {
    MyCircularQueue q(3);

    cout << q.enQueue(1) << endl;
    cout << q.enQueue(2) << endl;
    cout << q.enQueue(3) << endl;
    cout << q.enQueue(4) << endl;

    cout << q.Rear() << endl;
    cout << q.isFull() << endl;

    cout << q.deQueue() << endl;
    cout << q.enQueue(4) << endl;

    cout << q.Rear() << endl;

    return 0;
}