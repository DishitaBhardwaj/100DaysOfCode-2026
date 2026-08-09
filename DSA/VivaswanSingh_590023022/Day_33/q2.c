#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define MAX 100

char stack[MAX][MAX];
int top = -1;

void push(char str[])
{
    strcpy(stack[++top], str);
}

char* pop()
{
    return stack[top--];
}

int main()
{
    char postfix[MAX];
    scanf("%s", postfix);

    for (int i = 0; postfix[i] != '\0'; i++)
    {
        if (isalpha(postfix[i]))
        {
            char temp[2];
            temp[0] = postfix[i];
            temp[1] = '\0';
            push(temp);
        }
        else
        {
            char op2[MAX], op1[MAX], temp[MAX];

            strcpy(op2, pop());
            strcpy(op1, pop());

            temp[0] = postfix[i];
            temp[1] = '\0';

            strcat(temp, op1);
            strcat(temp, op2);

            push(temp);
        }
    }

    printf("%s\n", pop());

    return 0;
}