#include <stdio.h>
#include <string.h>
#include <ctype.h>
#define MAX 1000
int main() 
{
    char s[MAX];
    scanf("%s", s);
    char stack[MAX][MAX];
    int top=-1;
    for (int i=0;s[i]!='\0';i++) 
    {
        if (isalpha(s[i])) 
        {
            char temp[2];
            temp[0]=s[i];
            temp[1]='\0';
            strcpy(stack[++top],temp);
        }
        else 
            {
                char op2[MAX],op1[MAX],temp[MAX];
                strcpy(op2,stack[top--]);
                strcpy(op1,stack[top--]);
                temp[0]=s[i];
                temp[1]='\0';
                strcat(temp,op1);
                strcat(temp,op2);
                strcpy(stack[++top],temp);
            }
    }
    printf("%s", stack[top]);
    return 0;
}