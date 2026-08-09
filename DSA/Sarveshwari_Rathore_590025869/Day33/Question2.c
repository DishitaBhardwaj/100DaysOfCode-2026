#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

#define M 100
char stack[M][M];
int top = -1;
void push(char str[]){
    strcpy(stack[++top], str);
}
char* pop(){
    return stack[top--];
}
int main() {
    char postfix[M];
    printf("Enter postfix expression: ");
    scanf("%s", postfix);
    for(int i = 0; postfix[i] != '\0'; i++){
        if(isupper(postfix[i])){
            char temp[2];
            temp[0] = postfix[i];
            temp[1] = '\0';
            push(temp);
        } else{
            char op2[M], op1[M],result[M];
            strcpy(op2, pop());
            strcpy(op1, pop());
            result[0] = postfix[i];
            result[1] = '\0';
            strcat(result, op1);
            strcat(result, op2);
            push(result);
        }
    }
    printf("Prefix: %s\n",pop());
    return 0;
}