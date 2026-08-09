#include <iostream>
#include <deque>
using namespace std;

class FrontMiddleBackQueue {
private:
    deque<int> left, right;

    void balance() {
        if (left.size() > right.size()) {
            right.push_front(left.back());
            left.pop_back();
        }

        if (right.size() > left.size() + 1) {
            left.push_back(right.front());
            right.pop_front();
        }
    }

public:
    void pushFront(int val) {
        left.push_front(val);
        balance();
    }

    void pushMiddle(int val) {
        if (left.size() < right.size()) {
            left.push_back(val);
        } else {
            right.push_front(val);
        }
    }

    void pushBack(int val) {
        right.push_back(val);
        balance();
    }

    int popFront() {
        if (left.empty() && right.empty())
            return -1;

        int ans;

        if (!left.empty()) {
            ans = left.front();
            left.pop_front();
        } else {
            ans = right.front();
            right.pop_front();
        }

        balance();
        return ans;
    }

    int popMiddle() {
        if (left.empty() && right.empty())
            return -1;

        int ans;

        if (left.size() == right.size()) {
            ans = left.back();
            left.pop_back();
        } else {
            ans = right.front();
            right.pop_front();
        }

        balance();
        return ans;
    }

    int popBack() {
        if (left.empty() && right.empty())
            return -1;

        int ans = right.back();
        right.pop_back();

        balance();
        return ans;
    }
};

int main() {
    FrontMiddleBackQueue q;

    q.pushFront(1);
    q.pushBack(2);
    q.pushMiddle(3);
    q.pushMiddle(4);

    cout << q.popFront() << endl;
    cout << q.popMiddle() << endl;
    cout << q.popMiddle() << endl;
    cout << q.popBack() << endl;
    cout << q.popFront() << endl;

    return 0;
}