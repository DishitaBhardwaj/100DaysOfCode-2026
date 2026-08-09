class FrontMiddleBackQueue {
public:
    deque<int> dq;

    FrontMiddleBackQueue() {

    }

    void pushFront(int val) {
        dq.push_front(val);
    }

    void pushMiddle(int val) {
        auto it = dq.begin();
        advance(it, dq.size() / 2);
        dq.insert(it, val);
    }

    void pushBack(int val) {
        dq.push_back(val);
    }

    int popFront() {
        if (dq.empty())
            return -1;

        int x = dq.front();
        dq.pop_front();
        return x;
    }

    int popMiddle() {
        if (dq.empty())
            return -1;

        auto it = dq.begin();
        advance(it, (dq.size() - 1) / 2);

        int x = *it;
        dq.erase(it);

        return x;
    }

    int popBack() {
        if (dq.empty())
            return -1;

        int x = dq.back();
        dq.pop_back();

        return x;
    }
};
