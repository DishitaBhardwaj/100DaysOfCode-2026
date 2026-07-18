#include <iostream>
#include <stack>
#include <string>
using namespace std;

class Solution {
public:
    string postfixToPrefix(string s) {
        stack<string> st;

        for (char ch : s) {
            // If operand
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                st.push(string(1, ch));
            }
            // If operator
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
};

int main() {
    Solution obj;

    string s;
    cout << "Enter postfix expression: ";
    cin >> s;

    cout << "Prefix Expression: " << obj.postfixToPrefix(s) << endl;

    return 0;
}
