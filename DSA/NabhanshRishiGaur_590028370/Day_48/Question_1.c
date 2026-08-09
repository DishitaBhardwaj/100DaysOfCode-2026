static int COL;
static int K;

int cmp(const void* a, const void* b) {
    int* x = *(int**)a;
    int* y = *(int**)b;
    return y[K] - x[K];
}

int** sortTheStudents(int** score, int scoreSize,
                      int* scoreColSize, int k,
                      int* returnSize,
                      int** returnColumnSizes) {
    COL = scoreColSize[0];
    K = k;

    qsort(score, scoreSize, sizeof(int*), cmp);

    *returnSize = scoreSize;

    *returnColumnSizes = malloc(scoreSize * sizeof(int));
    for (int i = 0; i < scoreSize; i++)
        (*returnColumnSizes)[i] = COL;

    return score;
}
