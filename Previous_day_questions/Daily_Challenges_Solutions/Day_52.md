<h2 align="center">Week 8 Day 52</h2>

## 1. Check if All Characters Have Equal Number of Occurrences

### Solution

```c
#include <stdbool.h>
#include <string.h>

// Function to check if all characters occur the same number of times
bool areOccurrencesEqual(char* s) {
    // Frequency array for lowercase English letters
    int freq[26] = {0};
    int len = strlen(s);

    // Count occurrences of each character
    for (int i = 0; i < len; i++) {
        freq[s[i] - 'a']++;
    }

    // Find the frequency of the first character that appears
    int target = -1;
    for (int i = 0; i < 26; i++) {
        if (freq[i] > 0) {
            target = freq[i];
            break;
        }
    }

    // Compare every other character's frequency with target
    for (int i = 0; i < 26; i++) {
        if (freq[i] > 0 && freq[i] != target) {
            return false;
        }
    }

    return true;
}
```

---

## 2. Username Registration System

### Solution

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TABLE_SIZE 200003  // Large prime for hashing
#define MAX_LEN 40

// Node structure for chaining (hash table entry)
typedef struct Node {
    char username[MAX_LEN];
    int count;              // Number of times this base username was seen
    struct Node* next;
} Node;

Node* table[TABLE_SIZE];

// Simple polynomial hash function for strings
unsigned long hashString(const char* str) {
    unsigned long hash = 5381;
    int c;
    while ((c = *str++)) {
        hash = ((hash << 5) + hash) + c; // hash * 33 + c
    }
    return hash % TABLE_SIZE;
}

// Search for a username node in the hash table
Node* findNode(const char* username) {
    unsigned long idx = hashString(username);
    Node* curr = table[idx];
    while (curr != NULL) {
        if (strcmp(curr->username, username) == 0) {
            return curr;
        }
        curr = curr->next;
    }
    return NULL;
}

// Insert a new username node with count = 0
void insertNode(const char* username) {
    unsigned long idx = hashString(username);
    Node* newNode = (Node*)malloc(sizeof(Node));
    strcpy(newNode->username, username);
    newNode->count = 0;
    newNode->next = table[idx];
    table[idx] = newNode;
}

// Process a single registration request and return the assigned name
void registerUsername(const char* request, char* result) {
    Node* node = findNode(request);

    if (node == NULL) {
        // Username has never been used before
        insertNode(request);
        strcpy(result, "OK");
        return;
    }

    // Username already exists, find the smallest suffix that is free
    node->count++;
    char candidate[MAX_LEN];
    sprintf(candidate, "%s%d", request, node->count);

    // Ensure the generated candidate itself isn't already taken
    while (findNode(candidate) != NULL) {
        node->count++;
        sprintf(candidate, "%s%d", request, node->count);
    }

    insertNode(candidate);
    strcpy(result, candidate);
}

// Free all allocated hash table nodes
void freeTable(void) {
    for (int i = 0; i < TABLE_SIZE; i++) {
        Node* curr = table[i];
        while (curr != NULL) {
            Node* temp = curr;
            curr = curr->next;
            free(temp);
        }
    }
}

int main() {
    int n;
    printf("Enter number of requests: ");
    scanf("%d", &n);

    char request[MAX_LEN];
    char result[MAX_LEN];

    for (int i = 0; i < n; i++) {
        scanf("%s", request);
        registerUsername(request, result);
        printf("%s\n", result);
    }

    freeTable();
    return 0;
}
```
