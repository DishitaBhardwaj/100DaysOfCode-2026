#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX 100

char stack[MAX][MAX];
int top = -1;

void push(char str[]) {
    strcpy(stack[++top], str);
}

void pop(char str[]) {
    strcpy(str, stack[top--]);
}

int main() {

    char postfix[MAX];
    char op1[MAX], op2[MAX], temp[MAX];

    printf("Enter postfix expression: ");
    scanf("%s", postfix);

    for (int i = 0; postfix[i] != '\0'; i++) {

        if (isalnum(postfix[i])) {
            temp[0] = postfix[i];
            temp[1] = '\0';
            push(temp);
        }
        else {
            pop(op2);
            pop(op1);

            temp[0] = postfix[i];
            temp[1] = '\0';

            strcat(temp, op1);
            strcat(temp, op2);

            push(temp);
        }
    }

    printf("Prefix Expression: %s\n", stack[top]);

    return 0;
}