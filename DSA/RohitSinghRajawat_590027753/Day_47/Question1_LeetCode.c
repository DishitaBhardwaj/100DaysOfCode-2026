#include <stdlib.h>
#include <string.h>
#include <stdio.h>

typedef struct
{
    int score;
    int index;
} Athlete;

int compare(const void *a, const void *b)
{
    Athlete *x = (Athlete *)a;
    Athlete *y = (Athlete *)b;

    return y->score - x->score;
}

char** findRelativeRanks(int* score, int scoreSize, int* returnSize)
{
    Athlete *arr = (Athlete *)malloc(scoreSize * sizeof(Athlete));

    for(int i = 0; i < scoreSize; i++)
    {
        arr[i].score = score[i];
        arr[i].index = i;
    }

    qsort(arr, scoreSize, sizeof(Athlete), compare);

    char **ans = (char **)malloc(scoreSize * sizeof(char *));

    for(int i = 0; i < scoreSize; i++)
    {
        ans[arr[i].index] = (char *)malloc(20);

        if(i == 0)
            strcpy(ans[arr[i].index], "Gold Medal");
        else if(i == 1)
            strcpy(ans[arr[i].index], "Silver Medal");
        else if(i == 2)
            strcpy(ans[arr[i].index], "Bronze Medal");
        else
            sprintf(ans[arr[i].index], "%d", i + 1);
    }

    *returnSize = scoreSize;

    free(arr);

    return ans;
}