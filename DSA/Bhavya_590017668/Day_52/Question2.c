#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define TABLE_SIZE 200003
#define MAX_LEN 256
typedef struct Node{
    char name[MAX_LEN];
    int nextSuffix;
    struct Node *next;
}Node;
Node *table[TABLE_SIZE];
unsigned int hash(char *s){
    unsigned int h=0;
    while(*s) h=h*131+*s++;
    return h%TABLE_SIZE;
}
Node *find(char *name){
    unsigned int idx=hash(name);
    Node *cur=table[idx];
    while(cur){
        if(strcmp(cur->name,name)==0) return cur;
        cur=cur->next;
    }
    return NULL;
}
void insert(char *name){
    unsigned int idx=hash(name);
    Node *node=(Node*)malloc(sizeof(Node));
    strcpy(node->name,name);
    node->nextSuffix=1;
    node->next=table[idx];
    table[idx]=node;
}
void registerUsers(char requests[][MAX_LEN],int n,char result[][MAX_LEN]){
    for(int i=0;i<n;i++){
        Node *p=find(requests[i]);
        if(p==NULL){
            strcpy(result[i],"OK");
            insert(requests[i]);
        }else{
            char temp[MAX_LEN];
            int k=p->nextSuffix;
            while(1){
                sprintf(temp,"%s%d",requests[i],k);
                if(find(temp)==NULL) break;
                k++;
            }
            strcpy(result[i],temp);
            insert(temp);
            p->nextSuffix=k+1;
        }
    }
}