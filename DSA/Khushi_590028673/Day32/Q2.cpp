#include <iostream>
#include <stack>
using namespace std;

// Recursive function to copy stack
void copyStack(stack<int> &st, stack<int> &newStack) {
    if (st.empty())
        return;

    int x = st.top();
    st.pop();

    copyStack(st, newStack);

    st.push(x);       // Restore original stack
    newStack.push(x); // Copy to new stack
}

int main() {
    stack<int> st, newStack;
    int n, x;

    cout << "Enter number of elements: ";
    cin >> n;

    cout << "Enter elements (bottom to top): ";
    for (int i = 0; i < n; i++) {
        cin >> x;
        st.push(x);
    }

    copyStack(st, newStack);

    // Print original stack
    cout << "Original Stack (top to bottom): ";
    stack<int> temp = st;
    while (!temp.empty()) {
        cout << temp.top() << " ";
        temp.pop();
    }
    cout << endl;

    // Print copied stack
    cout << "Copied Stack (top to bottom): ";
    temp = newStack;
    while (!temp.empty()) {
        cout << temp.top() << " ";
        temp.pop();
    }
    cout << endl;

    return 0;
}