#include <iostream>
#include <stack>
#include <string>

using namespace std;

bool isOperator(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/';
}

string postfixtoprefix(const string &s) {
    stack<string> st;

    for (int i = 0; i < s.length(); i++) {
        if (!isOperator(s[i])) {
            st.push(string(1, s[i]));
        } else {
            string b = st.top();
            st.pop();
            string a = st.top();
            st.pop();
            st.push(string(1, s[i]) + a + b);
        }
    }

    return st.top();
}

int main() {
    string s = "ABC/-AK/L-*";
    cout << postfixtoprefix(s);
    return 0;
}
