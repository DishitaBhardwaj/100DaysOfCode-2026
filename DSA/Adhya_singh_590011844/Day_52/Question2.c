#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TABLE_SIZE 200003
#define MAX_NAME 40

typedef struct Node {
    char name[MAX_NAME];
    int count;
    struct Node *next;
} Node;

Node *table[TABLE_SIZE];

unsigned long hash(char *str) {
    unsigned long h = 5381;
    int c;
    while ((c = *str++))
        h = ((h << 5) + h) + c;
    return h % TABLE_SIZE;
}

Node* find(char *name) {
    unsigned long h = hash(name);
    Node *cur = table[h];

    while (cur) {
        if (strcmp(cur->name, name) == 0)
            return cur;
        cur = cur->next;
    }

    return NULL;
}

Node* insert(char *name) {
    unsigned long h = hash(name);

    Node *node = (Node *)malloc(sizeof(Node));
    strcpy(node->name, name);
    node->count = 1;

    node->next = table[h];
    table[h] = node;

    return node;
}

int main() {

    int n;
    scanf("%d", &n);

    char name[33];
    char newName[MAX_NAME];

    while (n--) {

        scanf("%32s", name);

        Node *base = find(name);

        if (base == NULL) {
            printf("OK\n");
            insert(name);
        } else {

            int suffix = base->count;

            while (1) {
                sprintf(newName, "%s%d", name, suffix);

                if (find(newName) == NULL) {
                    printf("%s\n", newName);

                    insert(newName);

                    base->count = suffix + 1;
                    break;
                }

                suffix++;
            }
        }
    }

    for (int i = 0; i < TABLE_SIZE; i++) {
        Node *cur = table[i];
        while (cur) {
            Node *temp = cur;
            cur = cur->next;
            free(temp);
        }
    }

    return 0;
}