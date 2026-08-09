#include <stdio.h>
#define SIZE 100

int stack[SIZE];
int top = -1;

// Push element onto stack
void push(int value) {
    if (top == SIZE - 1) {
        printf("Stack Overflow\n");
        return;
    }
    stack[++top] = value;
}

// Pop element from stack
int pop() {
    if (top == -1) {
        printf("Stack Underflow\n");
        return -1;
    }
    return stack[top--];
}

// Swap top two elements
void swapTop() {
    if (top < 1) {
        printf("Not enough elements to swap\n");
        return;
    }

    int temp = stack[top];
    stack[top] = stack[top - 1];
    stack[top - 1] = temp;
}

// Display stack from top to bottom
void display() {
    if (top == -1) {
        printf("Stack is empty\n");
        return;
    }

    printf("Remaining: ");
    for (int i = top; i >= 0; i--) {
        printf("%d ", stack[i]);
    }
    printf("\n");
}

int main() {
    push(101);
    push(102);
    push(103);
    push(104);

    swapTop();

    printf("Popped: %d\n", pop());

    display();
    return 0;
}