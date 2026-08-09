#include <stdio.h>
#include <string.h>

void removeOuterParentheses(char s[]) {
    int count = 0;

    for (int i = 0; s[i] != '\0'; i++) {
        if (s[i] == '(') {
            if (count > 0)
                printf("(");
            count++;
        } else { // s[i] == ')'
            count--;
            if (count > 0)
                printf(")");
        }
    }
    printf("\n");
}

int main() {
    char s[100001];

    printf("Enter the parentheses string: ");
    scanf("%s", s);

    printf("Result: ");
    removeOuterParentheses(s);
    return 0;
}