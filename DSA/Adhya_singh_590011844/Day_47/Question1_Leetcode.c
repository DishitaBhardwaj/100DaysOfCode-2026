#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int score;
    int index;
} Athlete;

int compare(const void *a, const void *b) {
    return ((Athlete *)b)->score - ((Athlete *)a)->score;
}

char** findRelativeRanks(int score[], int n) {
    Athlete *athletes = (Athlete *)malloc(n * sizeof(Athlete));

    for (int i = 0; i < n; i++) {
        athletes[i].score = score[i];
        athletes[i].index = i;
    }

    qsort(athletes, n, sizeof(Athlete), compare);

    char **answer = (char **)malloc(n * sizeof(char *));

    for (int i = 0; i < n; i++) {
        answer[athletes[i].index] = (char *)malloc(20);

        if (i == 0)
            strcpy(answer[athletes[i].index], "Gold Medal");
        else if (i == 1)
            strcpy(answer[athletes[i].index], "Silver Medal");
        else if (i == 2)
            strcpy(answer[athletes[i].index], "Bronze Medal");
        else
            sprintf(answer[athletes[i].index], "%d", i + 1);
    }

    free(athletes);

    return answer;
}

int main() {
    int n;

    printf("Enter number of athletes: ");
    scanf("%d", &n);

    int *score = (int *)malloc(n * sizeof(int));

    printf("Enter athlete scores:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &score[i]);
    }

    char **result = findRelativeRanks(score, n);

    printf("\nRanks:\n");
    for (int i = 0; i < n; i++) {
        printf("%s ", result[i]);
        free(result[i]);
    }

    printf("\n");

    free(result);
    free(score);

    return 0;
}