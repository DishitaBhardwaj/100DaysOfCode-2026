// Problem 1 
// Remove Outermost Parentheses 
// LeetCode Problem 1021

char* removeOuterParentheses(char* s) {
    int n = strlen(s);
    char stack[n];
    int top = -1;
    char *ans = (char *)malloc((n + 1) * sizeof(char));
    int j = 0;

    for (int i = 0; i < n; i++) {
        if (s[i] == '(') {
            if (top != -1) {
                ans[j++] = '(';
            }
            stack[++top] = '(';
        }

        else {
            top--;
            if (top != -1) {
                ans[j++] = ')';
            }
        }
    }

    ans[j] = '\0';
    return ans;
}