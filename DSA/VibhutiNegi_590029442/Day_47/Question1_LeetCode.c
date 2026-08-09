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
char** findRelativeRanks(int* score, int scoreSize, int* returnSize) {
    *returnSize = scoreSize;
    Athlete arr[scoreSize];
    for(int i = 0; i < scoreSize; i++)
    {
        arr[i].score = score[i];
        arr[i].index = i;
    }
    qsort(arr, scoreSize, sizeof(Athlete), compare);
    char **answer = (char **)malloc(scoreSize * sizeof(char *));
    for(int i = 0; i < scoreSize; i++)
    {
        answer[arr[i].index] = (char *)malloc(20 * sizeof(char));
        if(i == 0)
            strcpy(answer[arr[i].index], "Gold Medal");
        else if(i == 1)
            strcpy(answer[arr[i].index], "Silver Medal");
        else if(i == 2)
            strcpy(answer[arr[i].index], "Bronze Medal");
        else
            sprintf(answer[arr[i].index], "%d", i + 1);
    }
    return answer;
}
