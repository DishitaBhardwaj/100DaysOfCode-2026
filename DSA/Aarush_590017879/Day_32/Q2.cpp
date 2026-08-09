#include <iostream>
#include <stack>
using namespace std;

void copyStack(stack<int> st) {
    stack<int> temp, copied;

    // Move elements from original to temp
    while (!st.empty()) {
        temp.push(st.top());
        st.pop();
    }

    // Move elements from temp to copied
    while (!temp.empty()) {
        copied.push(temp.top());
        temp.pop();
    }

    // Print copied stack
    cout << "Copied Stack: [";

    stack<int> display = copied;
    while (!display.empty()) {
        cout << display.top();
        display.pop();

        if (!display.empty())
            cout << ",";
    }

    cout << "]" << endl;
}

int main() {
    stack<int> st;

    st.push(1);
    st.push(2);
    st.push(3);
    st.push(4);

    copyStack(st);

    return 0;
}