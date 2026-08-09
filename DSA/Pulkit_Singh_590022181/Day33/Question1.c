#include <stdio.h>
#include <string.h>

void removeOuterParentheses(char s[], char result[]) {
    int depth = 0;
    int j = 0;

    for (int i = 0; s[i] != '\0'; i++) {

        if (s[i] == '(') {
            if (depth > 0)
                result[j++] = s[i];

            depth++;
        }
        else {
            depth--;

            if (depth > 0)
                result[j++] = s[i];
        }
    }

    result[j] = '\0';
}

int main() {
    char s[] = "(()())(())";
    char result[1000];

    removeOuterParentheses(s, result);

    printf("Result: %s\n", result);

    return 0;
}