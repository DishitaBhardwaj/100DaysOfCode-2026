#include <stdio.h>
#include <stdlib.h>

int k; 

int compare(const void *a, const void *b) {
    int *row1 = *(int **)a;
    int *row2 = *(int **)b;

    return row2[k] - row1[k];
}

int main() {
    int m, n;

    printf("Enter number of students (rows): ");
    scanf("%d", &m);

    printf("Enter number of exams (columns): ");
    scanf("%d", &n);

    int **score = (int **)malloc(m * sizeof(int *));

    printf("Enter the score matrix:\n");
    for (int i = 0; i < m; i++) {
        score[i] = (int *)malloc(n * sizeof(int));
        for (int j = 0; j < n; j++) {
            scanf("%d", &score[i][j]);
        }
    }

    printf("Enter exam index k: ");
    scanf("%d", &k);

    // Sort rows
    qsort(score, m, sizeof(int *), compare);

    // Print sorted matrix
    printf("Sorted Matrix:\n");
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", score[i][j]);
        }
        printf("\n");
    }

    for (int i = 0; i < m; i++) {
        free(score[i]);
    }
    free(score);
    return 0;
}