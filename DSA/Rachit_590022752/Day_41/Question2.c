#include <stdio.h>
#include <string.h>

int main() {
    char jobs[1000];
    int sales[1000], marketing[1000];
    int sFront = 0, sBack = 0;
    int mFront = 0, mBack = 0;

    printf("Enter print job sequence: ");
    scanf("%s", jobs);

    int len = strlen(jobs);

    for (int i = 0; i < len; i++) {
        if (jobs[i] == 'S' || jobs[i] == 's')
            sales[sBack++] = i;
        else if (jobs[i] == 'M' || jobs[i] == 'm')
            marketing[mBack++] = i;
    }

    while (sFront < sBack && mFront < mBack) {
        int s = sales[sFront++];
        int m = marketing[mFront++];

        if (s < m)
            sales[sBack++] = s + len;
        else
            marketing[mBack++] = m + len;
    }

    if (sFront < sBack)
        printf("Sales\n");
    else
        printf("Marketing\n");

    return 0;
}
