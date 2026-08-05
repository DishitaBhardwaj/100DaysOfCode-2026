#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TABLE_SIZE 200003

typedef struct Node {
    char vendor[21];
    char lot[21];
    char cert[21];
    struct Node *next;
} Node;

Node *hashTable[TABLE_SIZE];

// djb2 hash function
unsigned long hashKey(const char *vendor, const char *lot) {
    unsigned long hash = 5381;
    int c;

    while ((c = *vendor++))
        hash = ((hash << 5) + hash) + c;

    while ((c = *lot++))
        hash = ((hash << 5) + hash) + c;

    return hash % TABLE_SIZE;
}

int firstInvalidRecord(char deliveries[][3][21], int n) {

    for (int i = 0; i < TABLE_SIZE; i++)
        hashTable[i] = NULL;

    for (int i = 0; i < n; i++) {

        char *vendor = deliveries[i][0];
        char *lot = deliveries[i][1];
        char *cert = deliveries[i][2];

        unsigned long h = hashKey(vendor, lot);

        Node *curr = hashTable[h];

        while (curr) {
            if (strcmp(curr->vendor, vendor) == 0 &&
                strcmp(curr->lot, lot) == 0) {

                if (strcmp(curr->cert, cert) != 0)
                    return i;

                break;
            }

            curr = curr->next;
        }

        if (curr == NULL) {
            Node *node = (Node *)malloc(sizeof(Node));

            strcpy(node->vendor, vendor);
            strcpy(node->lot, lot);
            strcpy(node->cert, cert);

            node->next = hashTable[h];
            hashTable[h] = node;
        }
    }

    return -1;
}

int main() {

    int n;

    printf("Enter number of delivery records: ");
    scanf("%d", &n);

    char deliveries[n][3][21];

    printf("Enter vendor_id lot_number cert_code:\n");

    for (int i = 0; i < n; i++) {
        scanf("%20s %20s %20s",
              deliveries[i][0],
              deliveries[i][1],
              deliveries[i][2]);
    }

    int ans = firstInvalidRecord(deliveries, n);

    printf("%d\n", ans);

    for (int i = 0; i < TABLE_SIZE; i++) {
        Node *curr = hashTable[i];
        while (curr) {
            Node *temp = curr;
            curr = curr->next;
            free(temp);
        }
    }

    return 0;
}