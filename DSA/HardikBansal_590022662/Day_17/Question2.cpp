#include<iostream>
using namespace std;
class Node{
    public:
    int data;
    Node* next;
    Node(int val)
    {
        data=val;
        next=NULL;
    }
    Node(int val,Node* ptr)
    {
        data=val;
        next=ptr;
    }
};
class Linked_list{
    public:
    Node* head=NULL;
    void insert(int x)
    {
        Node* newnode=new Node(x);
        if(head==NULL)
        {
            head=newnode;
        }
        else{
        Node* temp=head;
        while(temp->next!=NULL)
        {
            temp=temp->next;
        }
        temp->next=newnode;
    }
    }
    bool cycle(Node* head)
    {
        Node* slow=head,*fast=head;
        while(fast!=NULL && fast->next!=NULL)
        {
            slow=slow->next;
            fast=fast->next->next;
            if(fast==slow)
            {
                return true;
            }
        }
        return false;
    }
};
