#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string removeOuterParentheses(string s) {
        string ans;
        int depth = 0;

        for (char ch : s) {
            if (ch == '(') {
                if (depth > 0)
                    ans += ch;
                depth++;
            } else { // ch == ')'
                depth--;
                if (depth > 0)
                    ans += ch;
            }
        }

        return ans;
    }
};

int main() {
    Solution obj;

    string s;
    cout << "Enter the parentheses string: ";
    cin >> s;

    cout << "Output: " << obj.removeOuterParentheses(s) << endl;

    return 0;
}
