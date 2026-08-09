#include <stdio.h>
#define SIZE 5
int stack[SIZE], top = -1;

void push(int value){
    if (top == SIZE - 1){
        printf("Stack Full\n");
        return;                  //fix
    }
    top++;                       //fix
    stack[top] = value;          //fix
}

void pop()
{
    if (top == -1){
        printf("Stack Empty\n");
        return;                  //fix
    }
    int popped = stack[top];     //fix
    top--;                       //fix
    printf("Popped: %d\n", popped);
}

void swapTop(){
    if (top < 1){
        printf("Not enough elements\n");
        return;
    }
    int temp = stack[top];       //fix
    stack[top] = stack[top - 1]; //fix
    stack[top - 1] = temp;       //fix
}

void display(){
    if (top == -1){
        printf("Stack Empty\n");
        return;
    }
    printf("Remaining: ");
    int i = top;                 //fix
    while (i >= 0){
        printf("%d ", stack[i]);
        i--;
    }
    printf("\n");
}

int main(){
    push(101);
    push(102);
    push(103);
    push(104);
    swapTop();
    pop();
    display();
    return 0;
}