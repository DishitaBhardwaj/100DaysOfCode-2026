<h2 align="center">Week 6 Day 41 (25/07/2026)</h2>

## 1. Design Circular Queue

### Solution

```cpp
class MyCircularQueue {
private:
    vector<int> data;
    int head;   // index of front element
    int count;  // number of elements currently in queue
    int capacity;

public:
    MyCircularQueue(int k) {
        data.resize(k);
        head = 0;
        count = 0;
        capacity = k;
    }
    
    bool enQueue(int value) {
        if (isFull()) return false;
        int tailIndex = (head + count) % capacity;
        data[tailIndex] = value;
        count++;
        return true;
    }
    
    bool deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % capacity;
        count--;
        return true;
    }
    
    int Front() {
        if (isEmpty()) return -1;
        return data[head];
    }
    
    int Rear() {
        if (isEmpty()) return -1;
        int tailIndex = (head + count - 1) % capacity;
        return data[tailIndex];
    }
    
    bool isEmpty() {
        return count == 0;
    }
    
    bool isFull() {
        return count == capacity;
    }
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue* obj = new MyCircularQueue(k);
 * bool param_1 = obj->enQueue(value);
 * bool param_2 = obj->deQueue();
 * int param_3 = obj->Front();
 * int param_4 = obj->Rear();
 * bool param_5 = obj->isEmpty();
 * bool param_6 = obj->isFull();
 */
```

Key idea: instead of physically shifting elements, track `head` (front index) and `count` (number of elements). The rear index is computed as `(head + count - 1) % capacity`, and new elements are inserted at `(head + count) % capacity`. This gives O(1) time for every operation.

---

## 2. Office Printer Wars

### Solution

A queue-simulation "elimination with a pending ban" problem — every time a job is processed, it immediately reserves a cancellation for the next rival job it encounters. This is the same pattern behind the classic Dota2 Senate problem.

```cpp
#include <bits/stdc++.h>
using namespace std;

string officePrinterWars(string jobs) {
    queue<char> q;
    for (char c : jobs) q.push(c);

    int banS = 0; // pending cancellations Sales owes to Marketing
    int banM = 0; // pending cancellations Marketing owes to Sales
    int countS = count(jobs.begin(), jobs.end(), 'S');
    int countM = (int)jobs.size() - countS;

    while (countS > 0 && countM > 0) {
        char job = q.front();
        q.pop();

        if (job == 'S') {
            if (banS > 0) {
                // this Sales job gets cancelled by a pending Marketing ban
                banS--;
                countS--;
            } else {
                // process it, Sales now owes Marketing a cancellation
                banM++;
                q.push('S');
            }
        } else { // job == 'M'
            if (banM > 0) {
                banM--;
                countM--;
            } else {
                banS++;
                q.push('M');
            }
        }
    }

    return countS > 0 ? "Sales" : "Marketing";
}

int main(void) {
    cout << officePrinterWars("SM") << "\n";   // Sales
    cout << officePrinterWars("SMSM") << "\n"; // Sales
    cout << officePrinterWars("MSMS") << "\n"; // Marketing
    return 0;
}
```

Key idea: rather than tracking a snapshot of "who's left" after every single pop, keep running counts `countS`/`countM` of jobs still alive, and stop as soon as one side's count hits zero — avoiding the need to rescan the queue on every iteration. Each job either gets cancelled (decrementing the opposing count) or survives and re-enters the queue at the back, giving O(n) overall behavior.
