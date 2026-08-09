#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int score;
    int index;
} Athlete;

int compare(const void *a, const void *b) {
    Athlete *x = (Athlete *)a;
    Athlete *y = (Athlete *)b;
    return y->score - x->score;
}

int main() {
    int n;

    printf("Enter number of athletes: ");
    scanf("%d", &n);

    Athlete athletes[n];

    printf("Enter the scores:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &athletes[i].score);
        athletes[i].index = i;
    }

    qsort(athletes, n, sizeof(Athlete), compare);
    char answer[n][20];

    for (int i = 0; i < n; i++) {
        if (i == 0)
            strcpy(answer[athletes[i].index], "Gold Medal");
        else if (i == 1)
            strcpy(answer[athletes[i].index], "Silver Medal");
        else if (i == 2)
            strcpy(answer[athletes[i].index], "Bronze Medal");
        else
            sprintf(answer[athletes[i].index], "%d", i + 1);
    }

    printf("Ranks:\n[");
    for (int i = 0; i < n; i++) {
        printf("\"%s\"", answer[i]);
        if (i != n - 1)
            printf(", ");
    }
    printf("]\n");
    return 0;
}