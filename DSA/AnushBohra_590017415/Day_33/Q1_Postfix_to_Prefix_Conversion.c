#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX 1000

// Stack structure to hold dynamic strings
typedef struct Stack {
    int top;
    char* items[MAX];
} Stack;

void initStack(Stack* s) {
    s->top = -1;
}

int isEmpty(Stack* s) {
    return s->top == -1;
}

void push(Stack* s, char* str) {
    if (s->top >= MAX - 1) {
        printf("Stack Overflow\n");
        exit(1);
    }
    s->items[++(s->top)] = strdup(str); // Duplicate string to store safely
}

char* pop(Stack* s) {
    if (isEmpty(s)) {
        printf("Stack Underflow\n");
        exit(1);
    }
    return s->items[(s->top)--];
}

// Function to convert postfix to prefix
char* postfixToPrefix(char* postfix) {
    Stack s;
    initStack(&s);
    int length = strlen(postfix);

    for (int i = 0; i < length; i++) {
        char c = postfix[i];

        // If the character is an operand, push it to stack as a string
        if (isupper(c)) {
            char op[2] = {c, '\0'};
            push(&s, op);
        } 
        // If the character is an operator
        else if (c == '+' || c == '-' || c == '*' || c == '/') {
            // Pop two operands
            char* op2 = pop(&s);
            char* op1 = pop(&s);

            // Allocate memory for the combined prefix expression: operator + op1 + op2 + null terminator
            char* temp = (char*)malloc(strlen(op1) + strlen(op2) + 2);
            
            // Merge into prefix form: [operator][op1][op2]
            sprintf(temp, "%c%s%s", c, op1, op2);

            // Push the temporary string back to stack
            push(&s, temp);

            // Free intermediate allocated memory to prevent leaks
            free(op1);
            free(op2);
            free(temp);
        }
    }

    // The final element in the stack is the prefix expression
    return pop(&s);
}

int main() {
    // Test case from your example
    char postfix[] = "ABC/-AK/L-*";
    
    printf("Postfix Expression: %s\n", postfix);
    
    char* prefix = postfixToPrefix(postfix);
    
    printf("Prefix Expression:  %s\n", prefix);
    
    // Free final prefix string memory
    free(prefix);
    
    return 0;
}