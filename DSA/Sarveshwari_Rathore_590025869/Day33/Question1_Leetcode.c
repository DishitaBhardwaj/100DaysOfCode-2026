char* removeOuterParentheses(char* s) {
    int n = strlen(s);
    char *ans = (char *)malloc((n + 1) * sizeof(char));
    int d = 0;
    int j = 0;
    for (int i = 0; s[i] != '\0'; i++) {
        if (s[i] == '(') {
            if (d > 0)
                ans[j++] = '(';
            d++;
        }
        else {
            d--;
            if (d > 0)
                ans[j++] = ')';
        }
    }
    ans[j] = '\0';
    return ans;
}