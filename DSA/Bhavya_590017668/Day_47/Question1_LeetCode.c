typedef struct {
    int score;
    int index;
} Player;

int cmp(const void *a, const void *b) {
    return ((Player *)b)->score - ((Player *)a)->score;
}

char** findRelativeRanks(int* score, int scoreSize, int* returnSize) {
    Player *arr = (Player *)malloc(scoreSize * sizeof(Player));
    for (int i = 0; i < scoreSize; i++) {
        arr[i].score = score[i];
        arr[i].index = i;
    }

    qsort(arr, scoreSize, sizeof(Player), cmp);

    char **ans = (char **)malloc(scoreSize * sizeof(char *));
    for (int i = 0; i < scoreSize; i++) {
        int idx = arr[i].index;
        if (i == 0) {
            ans[idx] = (char *)malloc(13);
            strcpy(ans[idx], "Gold Medal");
        } else if (i == 1) {
            ans[idx] = (char *)malloc(13);
            strcpy(ans[idx], "Silver Medal");
        } else if (i == 2) {
            ans[idx] = (char *)malloc(13);
            strcpy(ans[idx], "Bronze Medal");
        } else {
            ans[idx] = (char *)malloc(12);
            sprintf(ans[idx], "%d", i + 1);
        }
    }

    free(arr);
    *returnSize = scoreSize;
    return ans;
}