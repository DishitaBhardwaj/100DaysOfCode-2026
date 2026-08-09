#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX 1000

char* postfixToPrefix(char *exp) {
    char *stack[MAX];
    int top = -1;

    for (int i = 0; exp[i] != '\0'; i++) {
        char ch = exp[i];

        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
            char *temp = (char *)malloc(2);
            temp[0] = ch;
            temp[1] = '\0';
            stack[++top] = temp;
        } else {
            char *op1 = stack[top--];
            char *op2 = stack[top--];

            int len = strlen(op1) + strlen(op2) + 2;
            char *temp = (char *)malloc(len);

            temp[0] = ch;
            temp[1] = '\0';
            strcat(temp, op2);
            strcat(temp, op1);

            stack[++top] = temp;
        }
    }

    return stack[top];
}

int main() {
    char exp[MAX];
    scanf("%s", exp);

    printf("%s\n", postfixToPrefix(exp));

    return 0;
}