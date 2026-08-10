# include <stdio.h>
#include <stdlib.h>
typedef struct ListNode{
   int val;
  struct ListNode* next;
}ListNode;
ListNode* middle(struct ListNode* head){
    ListNode* slow= head;
    ListNode* fast= head;
    while (fast!=NULL&& fast->next!=NULL)
    {
       slow=slow->next;
       fast=fast->next->next;
    }
    return slow;
}
