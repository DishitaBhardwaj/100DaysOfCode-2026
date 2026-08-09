/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int score;
    int index;
} Athlete;

int cmp(const void *a, const void *b) {
    Athlete *x = (Athlete *)a;
    Athlete *y = (Athlete *)b;
    return y->score - x->score;   // Descending order
}

char** findRelativeRanks(int* score, int scoreSize, int* returnSize) {
    *returnSize = scoreSize;

    Athlete *arr = (Athlete *)malloc(scoreSize * sizeof(Athlete));

    for (int i = 0; i < scoreSize; i++) {
        arr[i].score = score[i];
        arr[i].index = i;
    }

    qsort(arr, scoreSize, sizeof(Athlete), cmp);

    char **ans = (char **)malloc(scoreSize * sizeof(char *));

    for (int i = 0; i < scoreSize; i++) {
        ans[arr[i].index] = (char *)malloc(20 * sizeof(char));

        if (i == 0)
            strcpy(ans[arr[i].index], "Gold Medal");
        else if (i == 1)
            strcpy(ans[arr[i].index], "Silver Medal");
        else if (i == 2)
            strcpy(ans[arr[i].index], "Bronze Medal");
        else
            sprintf(ans[arr[i].index], "%d", i + 1);
    }

    free(arr);
    return ans;
}
