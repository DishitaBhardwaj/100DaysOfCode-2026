char* removeOuterParentheses(char* s) {
    static char ans[1000];
    int depth = 0;
    int j = 0;
    for (int i = 0; s[i] != '\0'; i++) {
        if (s[i] == '(') {
            if (depth > 0) {
                ans[j++] = '(';
            }
            depth++;
        }
        else {
            depth--;
            if (depth > 0) {
                ans[j++] = ')';
            }
        }
    }
    ans[j] = '\0';
    return ans;
