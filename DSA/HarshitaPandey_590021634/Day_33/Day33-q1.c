/*  Q1: Convert a valid postfix expression consisting of uppercase letters (A–Z) as operands 
and the operators +,-,*,/ (no parentheses, whitespace, or invalid characters) into 
its equivalent prefix expression using a stack based approach.

Example
Input:s = "ABC/-AK/L-*". Output:"*-A/BC-/AKL"    */



#include <stdio.h>


int isOperator(char c) 
{
    return (c == '+' || c == '-' || c == '*' || c == '/');
}


int isOperand(char c) 
{
    return (c >= 'A' && c <= 'Z');
}


int precedence(char c) 
{
    if (c == '+' || c == '-') 
        return 1;

    if (c == '*' || c == '/') 
        return 2;

    return 0;
}


int isEmpty(char *stack, int top) 
{
    return (top == -1);
}

int isFull(int top, int size) 
{
    return (top == size - 1);
}


int main() 
{
    char postfix[100], prefix[100];
    char stack[100][100];
    int top = -1, j = 0;

    printf("Enter a valid postfix expression: ");
    scanf("%s", postfix);

    for (int i = 0; postfix[i] != '\0'; i++) 
    {
        if (isOperand(postfix[i])) 
        {
            top++;
            stack[top][0] = postfix[i];
            stack[top][1] = '\0';
        } 

        else if (isOperator(postfix[i])) 
        {
            
            char op1[100], op2[100];
            strcpy(op2, stack[top--]);
            strcpy(op1, stack[top--]);

            
            char newExpr[100];
            newExpr[0] = postfix[i];
            newExpr[1] = '\0';
            strcat(newExpr, op1);
            strcat(newExpr, op2);

            
            top++;
            strcpy(stack[top], newExpr);
        }
    }

   
    strcpy(prefix, stack[top]);

    printf("Equivalent prefix expression: %s\n", prefix);

    return 0;
}