#include <string.h>
#include <stdlib.h>

char* removeOuterParentheses(char* s) {
    int n = strlen(s);
    char* result = (char*)malloc(n + 1);
    int idx = 0;
    int depth = 0;

    for (int i = 0; i < n; i++) {
        char c = s[i];
        if (c == '(') {
            if (depth > 0) result[idx++] = c;
            depth++;
        } else {
            depth--;
            if (depth > 0) result[idx++] = c;
        }
    }

    result[idx] = '\0';
    return result;
}