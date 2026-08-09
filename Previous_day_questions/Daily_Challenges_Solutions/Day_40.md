<h2 align="center">Week 6 Day 40 (24/07/2026)</h2>

## 1. Design Front Middle Back Queue

### Solution

```c
#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int val;
    struct Node *prev, *next;
} Node;

typedef struct {
    Node *front;
    Node *back;
    int size;
} FrontMiddleBackQueue;

FrontMiddleBackQueue* fmbqCreate() {
    FrontMiddleBackQueue* q = malloc(sizeof(FrontMiddleBackQueue));
    q->front = q->back = NULL;
    q->size = 0;
    return q;
}

static Node* newNode(int val) {
    Node* n = malloc(sizeof(Node));
    n->val = val;
    n->prev = n->next = NULL;
    return n;
}

void fmbqPushFront(FrontMiddleBackQueue* q, int val) {
    Node* n = newNode(val);
    if (q->size == 0) {
        q->front = q->back = n;
    } else {
        n->next = q->front;
        q->front->prev = n;
        q->front = n;
    }
    q->size++;
}

void fmbqPushBack(FrontMiddleBackQueue* q, int val) {
    Node* n = newNode(val);
    if (q->size == 0) {
        q->front = q->back = n;
    } else {
        n->prev = q->back;
        q->back->next = n;
        q->back = n;
    }
    q->size++;
}

/* returns node currently at 0-based index, traversing from the nearer end */
static Node* getNodeAt(FrontMiddleBackQueue* q, int index) {
    Node* cur;
    if (index <= q->size - 1 - index) {
        cur = q->front;
        for (int i = 0; i < index; i++) cur = cur->next;
    } else {
        cur = q->back;
        for (int i = q->size - 1; i > index; i--) cur = cur->prev;
    }
    return cur;
}

void fmbqPushMiddle(FrontMiddleBackQueue* q, int val) {
    int idx = q->size / 2;          /* insertion gap index */
    if (idx == 0) { fmbqPushFront(q, val); return; }
    if (idx == q->size) { fmbqPushBack(q, val); return; }

    Node* cur = getNodeAt(q, idx);  /* new node goes right before this node */
    Node* n = newNode(val);
    Node* p = cur->prev;
    p->next = n;
    n->prev = p;
    n->next = cur;
    cur->prev = n;
    q->size++;
}

int fmbqPopFront(FrontMiddleBackQueue* q) {
    if (q->size == 0) return -1;
    Node* n = q->front;
    int val = n->val;
    q->front = n->next;
    if (q->front) q->front->prev = NULL; else q->back = NULL;
    free(n);
    q->size--;
    return val;
}

int fmbqPopBack(FrontMiddleBackQueue* q) {
    if (q->size == 0) return -1;
    Node* n = q->back;
    int val = n->val;
    q->back = n->prev;
    if (q->back) q->back->next = NULL; else q->front = NULL;
    free(n);
    q->size--;
    return val;
}

int fmbqPopMiddle(FrontMiddleBackQueue* q) {
    if (q->size == 0) return -1;
    int idx = (q->size - 1) / 2;
    Node* cur = getNodeAt(q, idx);
    int val = cur->val;
    if (cur->prev) cur->prev->next = cur->next; else q->front = cur->next;
    if (cur->next) cur->next->prev = cur->prev; else q->back = cur->prev;
    free(cur);
    q->size--;
    return val;
}

void fmbqFree(FrontMiddleBackQueue* q) {
    Node* cur = q->front;
    while (cur) { Node* nx = cur->next; free(cur); cur = nx; }
    free(q);
}

int main(void) {
    FrontMiddleBackQueue* q = fmbqCreate();

    fmbqPushFront(q, 1);
    fmbqPushBack(q, 2);
    fmbqPushMiddle(q, 3);
    fmbqPushMiddle(q, 4);

    printf("%d\n", fmbqPopFront(q));   /* 1  */
    printf("%d\n", fmbqPopMiddle(q));  /* 3  */
    printf("%d\n", fmbqPopMiddle(q));  /* 4  */
    printf("%d\n", fmbqPopBack(q));    /* 2  */
    printf("%d\n", fmbqPopFront(q));   /* -1 */

    fmbqFree(q);
    return 0;
}
```

Compiles clean with `gcc -Wall` and the `main()` output matches the expected sequence: `1, 3, 4, 2, -1`.

---

## 2. Highest Temperature in Every Time Window

### Solution

```c
#include <stdio.h>
#include <stdlib.h>

/* Returns a malloc'd array of length (n - k + 1) with the max of every
   window of size k. Caller must free the returned array. */
int* slidingWindowMax(int* temps, int n, int k, int* outSize) {
    int* result = malloc((n - k + 1) * sizeof(int));
    int* dq = malloc(n * sizeof(int)); /* stores indices, values decreasing */
    int head = 0, tail = 0;            /* deque occupies dq[head..tail-1] */
    int ri = 0;

    for (int i = 0; i < n; i++) {
        /* drop indices that fell out of the window */
        while (head < tail && dq[head] <= i - k) head++;

        /* drop indices whose values are <= current value */
        while (head < tail && temps[dq[tail - 1]] <= temps[i]) tail--;

        dq[tail++] = i;

        if (i >= k - 1) {
            result[ri++] = temps[dq[head]];
        }
    }

    free(dq);
    *outSize = ri;
    return result;
}

static void printArray(int* arr, int n) {
    printf("[");
    for (int i = 0; i < n; i++) {
        printf("%d%s", arr[i], (i == n - 1) ? "" : ", ");
    }
    printf("]\n");
}

int main(void) {
    int t1[] = {1, 3, -1, -3, 5, 3, 6, 7};
    int t2[] = {9, 11, 8, 5, 7, 10};
    int t3[] = {4, 4, 4, 4};

    int size;
    int* r1 = slidingWindowMax(t1, 8, 3, &size);
    printArray(r1, size); free(r1);   /* [3, 3, 5, 5, 6, 7] */

    int* r2 = slidingWindowMax(t2, 6, 2, &size);
    printArray(r2, size); free(r2);   /* [11, 11, 8, 7, 10] */

    int* r3 = slidingWindowMax(t3, 4, 2, &size);
    printArray(r3, size); free(r3);   /* [4, 4, 4] */

    return 0;
}
```

Both solutions compile clean with `gcc -Wall` and their `main()` output matches the sample outputs exactly.
