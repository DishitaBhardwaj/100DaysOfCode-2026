#include <iostream>
#include <stack>
#include <string>
using namespace std;

string postfixToPrefix(string s) {
    stack<string> st;

    for (char ch : s) {

        if (ch >= 'A' && ch <= 'Z') {
            st.push(string(1, ch));
        }
        else {
            string op2 = st.top();
            st.pop();

            string op1 = st.top();
            st.pop();

            string temp = ch + op1 + op2;

            st.push(temp);
        }
    }

    return st.top();
}

int main() {
    string s = "ABC/-AK/L-*";

    cout << postfixToPrefix(s);

    return 0;
}