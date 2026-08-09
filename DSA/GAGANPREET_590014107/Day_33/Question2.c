#include <stdio.h>
#include <string.h>

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
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
}

int main() {
    char s[MAX];
    scanf("%s", s);

    for (int i = 0; s[i] != '\0'; i++) {

        if (s[i] >= 'A' && s[i] <= 'Z') {
            char temp[2];
            temp[0] = s[i];
            temp[1] = '\0';
            push(temp);
        }
        else if (isOperator(s[i])) {
            char op1[MAX], op2[MAX], temp[MAX];

            pop(op1);
            pop(op2);

            temp[0] = s[i];
            temp[1] = '\0';

            strcat(temp, op2);
            strcat(temp, op1);

            push(temp);
        }
    }

    printf("%s", stack[top]);

    return 0;
}
