#include <iostream>
#include <stack>
#include <string>
using namespace std;

int minLength(string s) {
    stack<char> st;

    for (char ch : s) {
        st.push(ch);

        while (st.size() >= 2) {
            char first = st.top();
            st.pop();

            char second = st.top();
            st.pop();

            if ((second == 'A' && first == 'B') ||
                (second == 'C' && first == 'D')) {
                continue;
            } else {
                st.push(second);
                st.push(first);
                break;
            }
        }
    }

    return st.size();
}

int main() {
    string s = "ABFCACDB";

    cout << "Minimum Length: " << minLength(s) << endl;

    return 0;
}