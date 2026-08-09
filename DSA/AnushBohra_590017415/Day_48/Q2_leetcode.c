#include <stdio.h>
#include <stdlib.h>

int K_COL = 0;

int compareRows(const void *a, const void *b) {
    int *rowA = *(int **)a;
    int *rowB = *(int **)b;
    return rowB[K_COL] - rowA[K_COL];
}

int** sortTheStudents(int** score, int scoreSize, int* scoreColSize, int k, int* returnSize, int** returnColumnSizes) {
    K_COL = k;

    qsort(score, scoreSize, sizeof(int *), compareRows);

    *returnSize = scoreSize;
    *returnColumnSizes = (int *)malloc(scoreSize * sizeof(int));
    for (int i = 0; i < scoreSize; i++) {
        (*returnColumnSizes)[i] = scoreColSize[i];
    }

    return score;
}

int main() {
    int m = 3, n = 4;
    int k = 2;

    // Sample input matrix: score = [[10,6,9,1],[7,5,11,2],[4,8,3,15]]
    int row0[] = {10, 6, 9, 1};
    int row1[] = {7, 5, 11, 2};
    int row2[] = {4, 8, 3, 15};

    int* score[3] = {row0, row1, row2};
    int scoreColSize[3] = {n, n, n};

    int returnSize;
    int* returnColumnSizes;

    int** result = sortTheStudents(score, m, scoreColSize, k, &returnSize, &returnColumnSizes);

    printf("Sorted Matrix (by exam %d):\n", k);
    for (int i = 0; i < returnSize; i++) {
        for (int j = 0; j < returnColumnSizes[i]; j++) {
            printf("%d ", result[i][j]);
        }
        printf("\n");
    }

    free(returnColumnSizes);
    return 0;
}