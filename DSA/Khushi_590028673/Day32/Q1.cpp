#include <iostream>
#include <stack>
#include <string>
using namespace std;

class Solution {
public:
    int minLength(string s) {
        stack<char> st;

        for (char c : s) {
            if (!st.empty() &&
                ((st.top() == 'A' && c == 'B') ||
                 (st.top() == 'C' && c == 'D'))) {
                st.pop();
            } else {
                st.push(c);
            }
        }

        return st.size();
    }
};

int main() {
    Solution obj;
    string s;

    cout << "Enter the string: ";
    cin >> s;

    cout << "Minimum length after removing AB and CD: "
         << obj.minLength(s) << endl;

    return 0;
}