#include<iostream>
#include<stack>
#include<string>
using namespace std;
class Solution{
public:
    string removeOuterParanthesis(string s){
        stack<char> st;
        string ans = "";
        for(char ch : s){
            if(ch == '('){
                if(!st.empty()){
                    ans = ans + ch;
                }
                st.push(ch);
            }else{
                st.pop();
                if(!st.empty()){
                    ans = ans + ch;
                }  
            }
        }
        return ans;
    }
};

int main(){
    Solution obj;

    string s = "(()())(())";
    cout<<obj.removeOuterParanthesis(s);
    return 0;
}