class FrontMiddleBackQueue {
public:
    deque<int> q;
    FrontMiddleBackQueue() {
    }
    void pushFront(int val) {
        q.push_front(val);
    }
    void pushMiddle(int val) {
        int index = q.size() / 2;
        q.insert(q.begin() + index, val);
    }
    void pushBack(int val) {
        q.push_back(val);
    }
    int popFront() {
        if(q.empty())
            return -1;
        int value = q.front();
        q.pop_front();
        return value;
    }
    int popMiddle() {
        if(q.empty())
            return -1;
        int index = (q.size() - 1) / 2;
        int value = q[index];
        q.erase(q.begin() + index);
        return value;
    }
    int popBack() {
        if(q.empty())
            return -1;
        int value = q.back();
        q.pop_back();
        return value;
    }
};
