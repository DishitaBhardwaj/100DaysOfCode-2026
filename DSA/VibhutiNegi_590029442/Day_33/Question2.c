#include <stdio.h>
#include <string.h>
char stack[100][100];
int top = -1;
void push(char* str) {
    top++;
    strcpy(stack[top], str);
}
char* pop() {
    return stack[top--];
}
char* postfixToPrefix(char* postfix) {
    static char result[1000];
    int n = strlen(postfix);
    for (int i = 0; i < n; i++) {
        char c = postfix[i];
        if (c >= 'A' && c <= 'Z') {
            char temp[2] = {c, '\0'};
            push(temp);
        }
        else if (c == '+' || c == '-' || c == '*' || c == '/') {
            char* operand2 = pop();
            char* operand1 = pop();  
            char newExpr[100];
            newExpr[0] = c;
            newExpr[1] = '\0';
            strcat(newExpr, operand1);
            strcat(newExpr, operand2);
            push(newExpr);
        }
    }
    strcpy(result, pop());
    return result;
}
int main() {
    char s[1000];
    printf("Enter postfix expression: ");
    scanf("%s", s);
    printf("Prefix expression: %s\n", postfixToPrefix(s));
    return 0;
}