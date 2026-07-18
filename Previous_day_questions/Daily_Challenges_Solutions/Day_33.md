<h2 align="center">Week 5 Day 33 (17/07/2026)</h2>

## 1. Remove Outermost Parentheses (LeetCode #1021)

### Solution

```c
char* removeOuterParentheses(char* s) {
    int n = strlen(s);
    // Allocate memory for the answer
    char* ans = (char*)malloc((n + 1) * sizeof(char));
    int depth = 0;   // Keeps track of current nesting level
    int j = 0;       // Index for answer string
    for (int i = 0; i < n; i++) {
        // If current character is '('
        if (s[i] == '(') {
            // If it is not the outermost opening bracket,
            // add it to the answer
            if (depth > 0) {
                ans[j++] = s[i];
            }
            // Increase nesting depth
            depth++;
        }
        else { // Current character is ')'
            // Decrease depth first
            depth--;
            // If it is not the outermost closing bracket,
            // add it to the answer
            if (depth > 0) {
                ans[j++] = s[i];
            }
        }
    }
    // Null terminate the answer string
    ans[j] = '\0';
    return ans;
}
```

---

## 2. Postfix to Prefix Conversion

### Solution

```c
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#define MAX 100

// Stack to store strings
char stack[MAX][MAX];
int top = -1;

// Push a string onto the stack
void push(char str[]) {
    strcpy(stack[++top], str);
}

// Pop a string from the stack
char* pop() {
    return stack[top--];
}

int main() {
    char postfix[MAX];
    printf("Enter postfix expression: ");
    scanf("%s", postfix);
    int n = strlen(postfix);
    for (int i = 0; i < n; i++) {
        // If current character is an operand, push it as a string
        if (isalpha(postfix[i])) {
            char temp[2];
            temp[0] = postfix[i];
            temp[1] = '\0';
            push(temp);
        }
        else {
            // Pop the top two operands
            char op1[MAX], op2[MAX];
            strcpy(op2, pop());   // Second operand
            strcpy(op1, pop());   // First operand
            // Create prefix expression: operator + first operand + second operand
            char temp[MAX];
            temp[0] = postfix[i];
            temp[1] = '\0';
            strcat(temp, op1);
            strcat(temp, op2);
            // Push the new expression back onto the stack
            push(temp);
        }
    }
    // Final answer is at the top of the stack
    printf("Prefix Expression: %s\n", pop());
    return 0;
}
```
