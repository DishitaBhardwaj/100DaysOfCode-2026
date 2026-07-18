class Solution {
    bool isOperand(char ch){
        return (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }
  public:
    string postToPre(string post_exp) {
        string s = post_exp;
        int n = s.size();
        stack<string> st;
        
        for(int i = 0; i < n; i++){
         if(isOperand(s[i]))  st.push({s[i]});
         else {
             string t1 = st.top(); st.pop();
             string t2 = st.top(); st.pop();
             
             string temp = s[i] + t2 + t1;
             st.push(temp);
         }
        }
        
        string ans = "";
        while(!st.empty()){
            ans += st.top();
            st.pop();
        }
        
        return ans;
    }
};