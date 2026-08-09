#include <stdio.h>
#include <string.h>
int main(){
    char s[1000];
    printf("Enter the expression:");
    scanf("%s", s);
    char stack[1000][1000];
    int top=-1;
    for (int i=0;s[i]!='\0';i++){
        char c=s[i];
        if((c>='A'&&c<='Z')){
            char temp[2];
            temp[0]=c;
            temp[1]='\0';
            strcpy(stack[++top], temp);
        }else{
            char op1[1000],op2[1000],res[1000];
            strcpy(op1,stack[top--]);
            strcpy(op2,stack[top--]);
            res[0]=c;
            res[1]='\0';
            strcat(res,op2);
            strcat(res,op1);
            strcpy(stack[++top],res);
        }
    }
    printf("%s\n", stack[top]);
    return 0;
}
