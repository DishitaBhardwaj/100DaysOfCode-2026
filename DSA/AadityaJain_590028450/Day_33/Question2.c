/*Postfix to Prefix Conversion
Explanation
Convert a valid postfix expression consisting of uppercase letters (A–Z) as operands and the operators +,-,*,/ (no parentheses, whitespace, or invalid characters) into its equivalent prefix expression using a stack based approach.*/

#include<stdio.h>
#include<ctype.h>
#define MAX 100

char stack[MAX][MAX];
int top = -1;

void push(char str[]){
    top++;
    int i = 0;

    while(str[i] != '\0'){
        stack[top][i] = str[i];
        i++;
    }

    stack[top][i] = '\0';
}

char* pop(){
    return stack[top--];
}

int main(){
    
    int i, j;
    char postfix[MAX];
    printf("Enter postfix expression: ");
    scanf("%s", postfix);

    for(i = 0; postfix[i] != '\0'; i++){
        if(isupper(postfix[i])){
            char temp[2];
            temp[0] = postfix[i];
            temp[1] = '\0';
            push(temp);
        }else{
            char *op2 = pop();
            char *op1 = pop();
            char temp[MAX];
            int k = 0;

            temp[k++] = postfix[i];

            j = 0;
            while(op1[j] != '\0'){
                temp[k++] = op1[j++];
            }

            j = 0;
            while(op2[j] != '\0'){
                temp[k++] = op2[j++];
            }

            temp[k] = '\0';

            push(temp);
        }
    }

    printf("Prefix Expression: %s\n", pop());

    return 0;
}