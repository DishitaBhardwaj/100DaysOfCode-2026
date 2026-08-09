#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX 100

char stack[MAX][MAX];
int top = -1;

void push(char str[]) {
    top++;
    strcpy(stack[top], str);
}

void pop(char str[]) {
    strcpy(str, stack[top]);
    top--;
}

int isOperator(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/';
}

void postfixToPrefix(char postfix[]) {

    char op1[MAX], op2[MAX], temp[MAX];

    for (int i = 0; postfix[i] != '\0'; i++) {

        char ch = postfix[i];

        // If operand, push it into stack
        if (ch >= 'A' && ch <= 'Z') {
            char operand[2];
            operand[0] = ch;
            operand[1] = '\0';

            push(operand);
        }

        // If operator
        else if (isOperator(ch)) {

            pop(op2);
            pop(op1);

            // Prefix = operator + operand1 + operand2
            temp[0] = ch;
            temp[1] = '\0';

            strcat(temp, op1);
            strcat(temp, op2);

            push(temp);
        }
    }

    printf("Prefix Expression: %s\n", stack[top]);
}

int main() {

    char s[] = "ABC/-AK/L-*";

    printf("Postfix Expression: %s\n", s);

    postfixToPrefix(s);

    return 0;
}