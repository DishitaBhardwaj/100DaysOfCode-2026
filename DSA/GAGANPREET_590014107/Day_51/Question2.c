#include <stdio.h>
#include <stdlib.h>

#define HASH_SIZE 100003

typedef struct Node {
    int vendor;
    int lot;
    int cert;
    struct Node *next;
} Node;

Node *hashTable[HASH_SIZE];

// Hash function
int hash(int vendor, int lot) {
    long long key = (long long)vendor * 1000003LL + lot;
    if (key < 0) key = -key;
    return key % HASH_SIZE;
}

// Returns index of first invalid record, or -1
int firstInvalidRecord(int records[][3], int n) {
    for (int i = 0; i < n; i++) {
        int vendor = records[i][0];
        int lot = records[i][1];
        int cert = records[i][2];

        int h = hash(vendor, lot);
        Node *curr = hashTable[h];

        while (curr) {
            if (curr->vendor == vendor && curr->lot == lot) {
                if (curr->cert != cert)
                    return i;
                break;
            }
            curr = curr->next;
        }

        if (curr == NULL) {
            Node *node = (Node *)malloc(sizeof(Node));
            node->vendor = vendor;
            node->lot = lot;
            node->cert = cert;
            node->next = hashTable[h];
            hashTable[h] = node;
        }
    }

    return -1;
}

int main() {
    int records[][3] = {
        {1, 101, 500},
        {2, 201, 700},
        {1, 101, 500},
        {1, 101, 900},   // First invalid record
        {2, 201, 700}
    };

    int n = sizeof(records) / sizeof(records[0]);

    printf("%d\n", firstInvalidRecord(records, n));

    return 0;
}
