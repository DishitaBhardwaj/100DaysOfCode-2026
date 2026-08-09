//Need to convert the postfix expression into prefix

#include <iostream>
#include <stack>
#include <string>
using namespace std;

bool isOperator(char ch)
{
    return ch == '+' || ch == '-' || ch == '*' || ch == '/';
}

int main()
{
    string postfix = "ABC/-AK/L-*";

    stack<string> st;

    for (char ch : postfix)
    {
        // operands can directly go into the stack
        if (!isOperator(ch))
        {
            st.push(string(1, ch));
        }
        else
        {
            // operator joins the latest two expressions
            string second = st.top();
            st.pop();

            string first = st.top();
            st.pop();

            string prefix = ch + first + second;

            st.push(prefix);
        }
    }

    cout << st.top();

    return 0;
}