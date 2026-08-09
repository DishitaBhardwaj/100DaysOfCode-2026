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

    printf("Enter scores: ");

    for (int i = 0; i < n; i++) {
        scanf("%d", &athletes[i].score);
        athletes[i].index = i;
    }

    qsort(athletes, n, sizeof(Athlete), compare);

    char ranks[n][20];

    for (int i = 0; i < n; i++) {

        int originalIndex = athletes[i].index;

        if (i == 0)
            strcpy(ranks[originalIndex], "Gold Medal");
        else if (i == 1)
            strcpy(ranks[originalIndex], "Silver Medal");
        else if (i == 2)
            strcpy(ranks[originalIndex], "Bronze Medal");
        else
            sprintf(ranks[originalIndex], "%d", i + 1);
    }

    printf("Ranks:\n");

    for (int i = 0; i < n; i++) {
        printf("%s ", ranks[i]);
    }

    printf("\n");

    return 0;
}