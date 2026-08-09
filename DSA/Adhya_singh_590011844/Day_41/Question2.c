#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* lastRemainingDepartment(char* jobs) {
    int n = strlen(jobs);

    int* sales = (int*)malloc(n * sizeof(int));
    int* marketing = (int*)malloc(n * sizeof(int));

    int salesFront = 0, salesRear = 0;
    int marketingFront = 0, marketingRear = 0;

    for (int i = 0; i < n; i++) {
        if (jobs[i] == 'S') {
            sales[salesRear++] = i;
        } else {
            marketing[marketingRear++] = i;
        }
    }

    while (salesFront < salesRear &&
           marketingFront < marketingRear) {

        int sIndex = sales[salesFront++];
        int mIndex = marketing[marketingFront++];

        if (sIndex < mIndex) {

            sales[salesRear++] = sIndex + n;
        } else {
            marketing[marketingRear++] = mIndex + n;
        }
    }

    char* result = (char*)malloc(10 * sizeof(char));

    if (salesFront < salesRear) {
        strcpy(result, "Sales");
    } else {
        strcpy(result, "Marketing");
    }

    free(sales);
    free(marketing);

    return result;
}

int main() {
    char jobs[10001];

    printf("Enter jobs: ");
    scanf("%10000s", jobs);

    char* result = lastRemainingDepartment(jobs);

    printf("Last remaining department: %s\n", result);

    free(result);

    return 0;
}