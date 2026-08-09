#include <stdio.h>
#include <string.h>
#include <ctype.h>

char stack[20][20];
int top = -1;

void push(char s[])
{
    top++;
    strcpy(stack[top], s);
}

void pop(char s[])
{
    strcpy(s, stack[top]);
    top--;
}

int main()
{
    char postfix[20];
    char op1[20], op2[20], temp[20];
    int i;

    printf("Enter the postfix expression: ");
    scanf("%s", postfix);

    for(i = 0; postfix[i] != '\0'; i++)
    {
        if(isalpha(postfix[i]))
        {
            temp[0] = postfix[i];
            temp[1] = '\0';
            push(temp);
        }
        else
        {
            pop(op2);
            pop(op1);

            temp[0] = postfix[i];
            temp[1] = '\0';

            strcat(temp, op1);
            strcat(temp, op2);

            push(temp);
        }
    }

    pop(temp);

    printf("Prefix Expression = %s", temp);
    return 0;
}
