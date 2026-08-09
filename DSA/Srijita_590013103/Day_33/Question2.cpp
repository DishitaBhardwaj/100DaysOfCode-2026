class Solution {
public:
    string postToPre(string postfix) {
        stack<string> st;

        for (char ch : postfix) {

            if (isalnum(ch)) {
                st.push(string(1, ch));
            }

            else {
                string op2 = st.top();
                st.pop();

                string op1 = st.top();
                st.pop();

                string expr = ch + op1 + op2;

                st.push(expr);
            }
        }

        return st.top();
    }
};