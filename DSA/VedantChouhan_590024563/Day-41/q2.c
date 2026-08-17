#include <stdio.h>
#include <string.h>

#define MAX 10000

int main() {

    char jobs[MAX + 1];
    printf("Enter job queue (S/M): ");
    scanf("%s", jobs);

    int n = strlen(jobs);

    int sales[MAX * 2], marketing[MAX * 2];
    int sf = 0, sr = 0;
    int mf = 0, mr = 0;

    // Store initial indices
    for (int i = 0; i < n; i++) {
        if (jobs[i] == 'S')
            sales[sr++] = i;
        else
            marketing[mr++] = i;
    }

    while (sf < sr && mf < mr) {

        int s = sales[sf++];
        int m = marketing[mf++];

        if (s < m)
            sales[sr++] = s + n;
        else
            marketing[mr++] = m + n;
    }

    if (sf < sr)
        printf("Sales\n");
    else
        printf("Marketing\n");

    return 0;
}