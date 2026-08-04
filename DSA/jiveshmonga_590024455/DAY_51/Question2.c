#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TABLE_SIZE 100003

typedef struct Node 
{
    int vendor_id;
    int lot_number;
    char cert_code[101];
    struct Node *next;
} Node;
Node *hashTable[TABLE_SIZE];

int hash(int vendor_id, int lot_number) {
    long long key = (long long)vendor_id * 1000003LL + lot_number;
    if (key < 0) key = -key;
    return key % TABLE_SIZE;
}
int firstInvalidRecord(int records[][2], char certs[][101], int n) {
    for (int i=0;i<n;i++) {
        int vendor=records[i][0];
        int lot=records[i][1];
        int h=hash(vendor,lot);
        Node *curr=hashTable[h];
        while (curr!=NULL) 
        {
            if (curr->vendor_id == vendor && curr->lot_number == lot) {
                if (strcmp(curr->cert_code, certs[i]) != 0)
                    return i;   // Conflict found
                break;
            }
            curr = curr->next;
        }

        if (curr==NULL) {
            Node *newNode = (Node *)malloc(sizeof(Node));
            newNode->vendor_id = vendor;
            newNode->lot_number = lot;
            strcpy(newNode->cert_code, certs[i]);
            newNode->next = hashTable[h];
            hashTable[h] = newNode;
        }
    }
    return -1;
}
int main() 
{
    int n=5;
    int records[5][2]={
        {1, 100},
        {2, 200},
        {1, 100},
        {3, 300},
        {1, 100}
    };
    char certs[5][101] = 
    {
        "ABC",
        "XYZ",
        "ABC",
        "PQR",
        "DEF"
    };
    printf("%d\n", firstInvalidRecord(records, certs, n));
    return 0;
}