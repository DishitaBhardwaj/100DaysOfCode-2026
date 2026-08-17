#include <stdio.h>
#include <stdlib.h>
#include <string.h>

const char* predictPartyVictory(char* jobs) {
    int n = strlen(jobs);
    int* salesQueue = (int*)malloc(n * sizeof(int));
    int* marketingQueue = (int*)malloc(n * sizeof(int));
    
    int sFront = 0, sRear = 0;
    int mFront = 0, mRear = 0;

    for (int i = 0; i < n; i++) {
        if (jobs[i] == 'S') {
            salesQueue[sRear++] = i;
        } else {
            marketingQueue[mRear++] = i;
        }
    }

    while (sFront < sRear && mFront < mRear) {
        int sIndex = salesQueue[sFront++];
        int mIndex = marketingQueue[mFront++];

        if (sIndex < mIndex) {
            salesQueue[sRear++] = sIndex + n;
        } else {
            marketingQueue[mRear++] = mIndex + n;
        }
    }

    const char* winner = (sFront < sRear) ? "Sales" : "Marketing";

    free(salesQueue);
    free(marketingQueue);

    return winner;
}

int main() {
    char jobs1[] = "SMM";
    printf("Input: %s -> Output: %s\n", jobs1, predictPartyVictory(jobs1));

    char jobs2[] = "SMSM";
    printf("Input: %s -> Output: %s\n", jobs2, predictPartyVictory(jobs2));

    return 0;
}