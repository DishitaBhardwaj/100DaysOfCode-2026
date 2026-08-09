#include <iostream>
#include <stack>
#include <string>
using namespace std;

bool isOperator(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/';
}
string postfixToPrefix(string expression) {
    stack<string> st;
    for(char ch : expression) {
        if(isOperator(ch)) {
            string second = st.top();
            st.pop();
            string first = st.top();
            st.pop();
            string current = ch + first + second;
            st.push(current);
        }
        else {
            st.push(string(1, ch));
        }
    }
    return st.top();
}
int main() {
    string expression;
    cout << "Enter the postfix expression: ";
    cin >> expression;
    cout << "Prefix expression: "
         << postfixToPrefix(expression);
    return 0;
}
