#include <stdio.h>
#include <stdlib.h>

int col;

int compare(const void *a, const void *b) {
    int *row1 = *(int **)a;
    int *row2 = *(int **)b;

    return row2[col] - row1[col];  
}

void sortStudents(int **score, int m, int n, int k) {
    col = k;
    qsort(score, m, sizeof(int *), compare);
}

int main() {
    int m, n, k;

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

    sortStudents(score, m, n, k);

    printf("\nSorted Matrix:\n");
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", score[i][j]);
        }
        printf("\n");
    }

    for (int i = 0; i < m; i++)
        free(score[i]);
    free(score);

    return 0;
}