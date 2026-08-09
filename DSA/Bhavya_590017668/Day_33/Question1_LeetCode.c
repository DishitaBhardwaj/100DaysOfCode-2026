char* removeOuterParentheses(char* s) {
    int i = 0, balance = 0, j = 0;
    while (s[i] != '\0')
        i++;
    char *ans = (char *)malloc((i + 1) * sizeof(char));
    i = 0;
    while (s[i] != '\0') {
        if (s[i] == '(') {
            if (balance > 0)
                ans[j++] = s[i];
            balance++;
        } else {
            balance--;
            if (balance > 0)
                ans[j++] = s[i];
        }
        i++;
    }
    ans[j] = '\0';
    return ans;
}