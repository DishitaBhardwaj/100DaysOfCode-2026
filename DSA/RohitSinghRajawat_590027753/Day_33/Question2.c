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
    char postfix[] = "ABC/-AK/L-*";

    for(int i = 0; postfix[i] != '\0'; i++)
    {
        if(isalpha(postfix[i]))
        {
            char temp[2];
            temp[0] = postfix[i];
            temp[1] = '\0';

            push(temp);
        }
        else
        {
            char op1[MAX], op2[MAX], result[MAX];

            strcpy(op1, pop());
            strcpy(op2, pop());

            result[0] = postfix[i];
            result[1] = '\0';

            strcat(result, op2);
            strcat(result, op1);

            push(result);
        }
    }

    printf("Prefix Expression: %s\n", pop());

    return 0;
}