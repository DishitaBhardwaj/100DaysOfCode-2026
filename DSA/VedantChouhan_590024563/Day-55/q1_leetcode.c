#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int value;
    int index;
} Element;

int compare(const void *a, const void *b) {
    Element *x = (Element *)a;
    Element *y = (Element *)b;

    return y->value - x->value;
}

int main() {

    int n, k;

    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter the elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    printf("Enter k: ");
    scanf("%d", &k);

    Element elements[n];

    for (int i = 0; i < n; i++) {
        elements[i].value = nums[i];
        elements[i].index = i;
    }

    // Sort elements by value in descending order
    qsort(elements, n, sizeof(Element), compare);

    int selected[n];

    for (int i = 0; i < n; i++) {
        selected[i] = 0;
    }

    // Select k largest elements
    for (int i = 0; i < k; i++) {
        selected[elements[i].index] = 1;
    }

    printf("Largest Sum Subsequence: ");

    // Traverse original array to preserve order
    for (int i = 0; i < n; i++) {
        if (selected[i]) {
            printf("%d ", nums[i]);
        }
    }

    printf("\n");

    return 0;
}