#include <stdio.h>
#include <stdlib.h>
typedef struct ListNode{
    int val;
    struct ListNode* next;
}ListNode;
ListNode* separate(ListNode* head){
    if(head==NULL|| head->next ==NULL)
    return head;
    ListNode* evenhead=NULL;
    ListNode* eventail=NULL;
    ListNode* oddhead=NULL;
    ListNode* oddtail=NULL;
    ListNode* curr=head;
    while(curr!=NULL){
        ListNode* nextnode=curr->next;
        curr->next=NULL;
        if(curr->val%2==0){
            if(evenhead==NULL){
                evenhead=curr;
                eventail=curr;
            }
            else{
            eventail->next=curr;
            eventail=curr;
            }
        }else{
            if(oddhead==NULL){
                oddhead=curr;
                oddtail=curr;
            }
            else{
            oddtail->next=curr;
            oddtail=curr;
            }
        }
        curr=nextnode;
    }
    if(evenhead==NULL)
    return oddhead;
    if(oddhead==NULL)
    return evenhead;
    eventail->next=oddhead;
    return evenhead;
}