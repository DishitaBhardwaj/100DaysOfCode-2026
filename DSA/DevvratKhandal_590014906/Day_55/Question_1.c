#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int value;
    int index;
} Element;

int compareValue(const void *a, const void *b) {
    Element *x = (Element *)a;
    Element *y = (Element *)b;

    return y->value - x->value;   // descending
}

int compareIndex(const void *a, const void *b) {
    Element *x = (Element *)a;
    Element *y = (Element *)b;

    return x->index - y->index;   // ascending
}

int main() {
    int n, k;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int nums[n];
    Element arr[n];

    printf("Enter elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);

        arr[i].value = nums[i];
        arr[i].index = i;
    }

    printf("Enter k: ");
    scanf("%d", &k);

    // Sort according to value
    qsort(arr, n, sizeof(Element), compareValue);

    // Select top k elements
    Element selected[k];

    for (int i = 0; i < k; i++) {
        selected[i] = arr[i];
    }

    qsort(selected, k, sizeof(Element), compareIndex);

    printf("Output: [");

    for (int i = 0; i < k; i++) {
        printf("%d", selected[i].value);

        if (i < k - 1)
            printf(",");
    }

    printf("]\n");

    return 0;
}