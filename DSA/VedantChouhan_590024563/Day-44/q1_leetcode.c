#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int main() {

    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter the elements: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    qsort(arr, n, sizeof(int), compare);

    int diff = arr[1] - arr[0];
    int flag = 1;

    for (int i = 2; i < n; i++) {
        if (arr[i] - arr[i - 1] != diff) {
            flag = 0;
            break;
        }
    }

    if (flag)
        printf("True\n");
    else
        printf("False\n");

    return 0;
}