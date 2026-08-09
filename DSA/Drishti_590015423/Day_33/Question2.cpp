#include <iostream>
#include <stack>
using namespace std;

string postToPre(string s)
{
    stack<string> st;

    for (char ch : s)
    {
        // Operand
        if (ch >= 'A' && ch <= 'Z')
        {
            st.push(string(1, ch));
        }
        // Operator
        else
        {
            string op1 = st.top();
            st.pop();

            string op2 = st.top();
            st.pop();

            string temp = ch + op2 + op1;

            st.push(temp);
        }
    }

    return st.top();
}

int main()
{
    string s = "ABC/-AK/L-*";

    cout << postToPre(s);

    return 0;
}
