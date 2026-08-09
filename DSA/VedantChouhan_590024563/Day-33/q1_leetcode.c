#include <stdio.h>
#include <string.h>

void removeOuterParentheses(char s[], char result[]) {

    int depth = 0;
    int index = 0;

    for (int i = 0; s[i] != '\0'; i++) {

        if (s[i] == '(') {

            if (depth > 0)
                result[index++] = '(';

            depth++;
        }
        else {

            depth--;

            if (depth > 0)
                result[index++] = ')';
        }
    }

    result[index] = '\0';
}

int main() {

    char s[1000];
    char result[1000];

    printf("Enter parentheses string: ");
    scanf("%s", s);

    removeOuterParentheses(s, result);

    printf("Result: %s\n", result);

    return 0;
}