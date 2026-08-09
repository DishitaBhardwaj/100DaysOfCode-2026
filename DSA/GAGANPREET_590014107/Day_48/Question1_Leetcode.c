/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int col;

int compare(const void *a, const void *b) {
    int *row1 = *(int **)a;
    int *row2 = *(int **)b;

    return row2[col] - row1[col];   // Descending order
}

int** sortTheStudents(int** score, int scoreSize, int* scoreColSize, int k,
                      int* returnSize, int** returnColumnSizes) {

    col = k;

    qsort(score, scoreSize, sizeof(int *), compare);

    *returnSize = scoreSize;
    *returnColumnSizes = (int *)malloc(scoreSize * sizeof(int));

    for (int i = 0; i < scoreSize; i++) {
        (*returnColumnSizes)[i] = *scoreColSize;
    }

    return score;
}
