/*  Q1: Copy all elements from one stack to another while preserving the original order
using only stack operations, and print the copied stack.

Example:
Input:st = [1,2,3,4];  Output:[1,2,3,4]    */


#include <stdio.h>
#define MAX 100

int stack1[MAX], stack2[MAX];
int top1 = -1, top2 = -1;

void push(int value) 
{
    if (top1 == MAX - 1) 
    {
        printf("Stack overflow\n");
    } 
    
    else 
    {
        stack1[++top1] = value;
    }
    
}

void pop() 
{
    if (top1 == -1) 
    {
        printf("Stack underflow\n");
    } 
    
    else 
    {
        top1--;
    }
    
}


int main()
{
    int n, i, value;
    printf("Enter the number of elements in the stack: ");
    scanf("%d", &n);

    printf("Enter the elements of the stack:\n");
    for (i = 0; i < n; i++) 
    {
        scanf("%d", &value);
        push(value);
    }

    
    while (top1 != -1)
    {
        stack2[++top2] = stack1[top1--];
    }


    int temp[MAX], t = -1;
    while (top1 != -1)
    {
         temp[++t] = stack1[top1--];
    }
    
    while (t != -1)
   {
        stack1[++top1] = temp[t];
        stack2[++top2] = temp[t--];
   }

    printf("Copied stack: ");
 
    for (i = 0; i <= top2; i++)
   {
      printf("%d", stack2[i]);
      
      if (i != top2) printf(", ");
   }
   
   printf("\n");
    

    return 0;
}