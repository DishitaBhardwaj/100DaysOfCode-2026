class Solution {
public:
    string removeOuterParentheses(string s) {
        string result = "";
        stack <char> st;
        for( char ch: s){
            if(ch == '('){
                if(!st.empty()){
                    result+= ch;
                }
                st.push(ch);
            }
                else{
                    st.pop();
                    if(!st.empty()){
                        result+=ch;
                    }
                }
        }
        return result;
    }
};