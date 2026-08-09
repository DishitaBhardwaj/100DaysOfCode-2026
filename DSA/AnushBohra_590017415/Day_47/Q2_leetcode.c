#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int score;
    int original_index;
} Athlete;

int compare(const void* a, const void* b) {
    Athlete* athleteA = (Athlete*)a;
    Athlete* athleteB = (Athlete*)b;
    return athleteB->score - athleteA->score;
}

char** findRelativeRanks(int* score, int scoreSize, int* returnSize) {
    *returnSize = scoreSize;
    
    char** result = (char**)malloc(scoreSize * sizeof(char*));
    Athlete* athletes = (Athlete*)malloc(scoreSize * sizeof(Athlete));
    
    for (int i = 0; i < scoreSize; i++) {
        athletes[i].score = score[i];
        athletes[i].original_index = i;
    }
    
    qsort(athletes, scoreSize, sizeof(Athlete), compare);
    
    for (int rank = 0; rank < scoreSize; rank++) {
        int orig_idx = athletes[rank].original_index;
        result[orig_idx] = (char*)malloc(15 * sizeof(char));
        
        if (rank == 0) {
            strcpy(result[orig_idx], "Gold Medal");
        } else if (rank == 1) {
            strcpy(result[orig_idx], "Silver Medal");
        } else if (rank == 2) {
            strcpy(result[orig_idx], "Bronze Medal");
        } else {
            sprintf(result[orig_idx], "%d", rank + 1);
        }
    }
    
    free(athletes);
    return result;
}

// Helper function to print results and clean up memory
void printAndFreeResult(char** result, int size) {
    printf("[");
    for (int i = 0; i < size; i++) {
        printf("\"%s\"%s", result[i], (i == size - 1) ? "" : ", ");
        free(result[i]); // Free individual string allocation
    }
    printf("]\n");
    free(result); // Free array of string pointers
}

int main() {
    int returnSize;

    // Test Case 1
    int score1[] = {5, 4, 3, 2, 1};
    int size1 = sizeof(score1) / sizeof(score1[0]);
    char** result1 = findRelativeRanks(score1, size1, &returnSize);
    printf("Test Case 1 Output:\n");
    printAndFreeResult(result1, returnSize);

    // Test Case 2
    int score2[] = {10, 3, 8, 9, 4};
    int size2 = sizeof(score2) / sizeof(score2[0]);
    char** result2 = findRelativeRanks(score2, size2, &returnSize);
    printf("\nTest Case 2 Output:\n");
    printAndFreeResult(result2, returnSize);

    return 0;
}