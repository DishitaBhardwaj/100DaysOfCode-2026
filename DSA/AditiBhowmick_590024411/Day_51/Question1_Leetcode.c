#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int value;
    int count;
} Element;

int compare(const void *a, const void *b) {
    Element *x = (Element *)a;
    Element *y = (Element *)b;

    if (x->value != y->value)
        return x->value - y->value;

    return 0;
}

int main() {
    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter array elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    Element even[n];
    int size = 0;

    for (int i = 0; i < n; i++) {
        if (nums[i] % 2 == 0) {
            even[size].value = nums[i];
            even[size].count = 0;
            size++;
        }
    }

    if (size == 0) {
        printf("-1\n");
        return 0;
    }

    qsort(even, size, sizeof(Element), compare);

    int maxFreq = 0;
    int answer = -1;

    int i = 0;
    while (i < size) {
        int count = 1;
        while (i + 1 < size && even[i].value == even[i + 1].value) {
            count++;
            i++;
        }

        if (count > maxFreq || (count == maxFreq && even[i].value < answer)) {
            maxFreq = count;
            answer = even[i].value;
        }
        i++;
    }

    printf("Most frequent even element: %d\n", answer);
    return 0;
}