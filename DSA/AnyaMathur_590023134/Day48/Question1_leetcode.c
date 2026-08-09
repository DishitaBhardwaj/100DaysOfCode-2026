// Leetcode Problem 2545
// Sort the Students by Their Kth Score 

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int** sortTheStudents(int** score, int scoreSize, int* scoreColSize, int k, int* returnSize, int** returnColumnSizes) {
    for(int i = 0; i < scoreSize - 1; i++) {
        int highest = i;
        for(int j = i + 1; j < scoreSize; j++) {
            if(score[j][k] > score[highest][k]) {
                highest = j;
            }
        }
        if(highest != i) {
            int* temp = score[i];
            score[i] = score[highest];
            score[highest] = temp;
        }
    }
    *returnSize = scoreSize;
    *returnColumnSizes = (int*)malloc(scoreSize * sizeof(int));
    for(int i = 0; i < scoreSize; i++) {
        (*returnColumnSizes)[i] = *scoreColSize;
    }
    return score;
}