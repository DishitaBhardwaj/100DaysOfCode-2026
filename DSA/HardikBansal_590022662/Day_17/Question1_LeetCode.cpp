class Solution {
public:
    ListNode* middle(ListNode* head)
    {
        ListNode* slow=head,*fast=head;
        while(fast && fast->next)
        {
            slow=slow->next;
            fast=fast->next->next;
        }
        return slow;
    }
    ListNode* reverse(ListNode* head)
    {
        ListNode* prev=NULL,*next=NULL,*curr=head;
        while(curr!=NULL)
        {
            next=curr->next;
            curr->next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    bool compare(ListNode* head,ListNode* middle)
    {
        while(head!=NULL && middle!=NULL)
        {
            if(head->val!=middle->val)
            {
                return false;
            }
            head=head->next;
            middle=middle->next;
        }
        return true;
        }
    


    bool isPalindrome(ListNode* head) {
        ListNode* slow=middle(head);
        ListNode* head_of_reverse=reverse(slow);
        return compare(head,head_of_reverse);
        
    }
};