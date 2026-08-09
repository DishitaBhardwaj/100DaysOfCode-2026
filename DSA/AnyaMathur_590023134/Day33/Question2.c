// Problem 2 
// Postfix to Prefix Conversion

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {

    char postfix[100];
    printf("Enter postfix expression: ");
    scanf("%s", postfix);

    char stack[100][100];
    int top = -1;

    for (int i = 0; postfix[i] != '\0'; i++) {
        char ch = postfix[i];

        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
            char temp[2];
            temp[0] = ch;
            temp[1] = '\0';
            strcpy(stack[++top], temp);
        }
        else {
            char op1[100], op2[100], temp[100];

            strcpy(op1, stack[top--]);
            strcpy(op2, stack[top--]);

            temp[0] = ch;
            temp[1] = '\0';

            strcat(temp, op2);
            strcat(temp, op1);

            strcpy(stack[++top], temp);
        }
    }

    printf("Prefix Expression: %s", stack[top]);

    return 0;
}