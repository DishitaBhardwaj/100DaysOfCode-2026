/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
typedef struct
{
    int score;
    int index;
} Athlete;

int compare(const void *a, const void *b)
{
    return ((Athlete *)b)->score - ((Athlete *)a)->score;
}

char** findRelativeRanks(int* score, int scoreSize, int* returnSize)
{
    Athlete *arr = (Athlete *)malloc(scoreSize * sizeof(Athlete));

    for (int i = 0; i < scoreSize; i++)
    {
        arr[i].score = score[i];
        arr[i].index = i;
    }

    qsort(arr, scoreSize, sizeof(Athlete), compare);

    char **answer = (char **)malloc(scoreSize * sizeof(char *));

    for (int i = 0; i < scoreSize; i++)
    {
        if (i == 0)
            answer[arr[i].index] = "Gold Medal";
        else if (i == 1)
            answer[arr[i].index] = "Silver Medal";
        else if (i == 2)
            answer[arr[i].index] = "Bronze Medal";
        else
        {
            answer[arr[i].index] = (char *)malloc(12);
            sprintf(answer[arr[i].index], "%d", i + 1);
        }
    }

    *returnSize = scoreSize;
    free(arr);

    return answer;
}