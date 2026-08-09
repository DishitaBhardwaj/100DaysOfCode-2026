/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeElements(struct ListNode* head, int val) {
    struct ListNode dummy;
    dummy.next=head;
   struct ListNode* curr=head;
   struct ListNode* prev=&dummy;
   if(head=NULL)
   return NULL;
   while(curr!=NULL){
    if(curr->val==val){
        prev->next=curr->next;
        struct ListNode* temp=curr;
        curr=curr->next;
        free(temp);
        }
        else{
            prev=curr;
            curr=curr->next;
        }
   }
   return dummy.next;// we used dummy in case the head is to be deleted as the dummy.next points to the list with deleted head and head always returns from the first node
}// prev is being updated every time if the val doesnt match 