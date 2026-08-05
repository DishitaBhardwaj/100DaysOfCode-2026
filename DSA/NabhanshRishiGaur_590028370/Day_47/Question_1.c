int binSearch(int *a, int n, int val);

int compare(const void *a, const void *b) {
    return *(int*) b - *(int*) a;
}

char** findRelativeRanks(int* score, int scoreSize, int* returnSize) {
    int i, rank, ranks[scoreSize];
    char **placements = (char**) malloc(scoreSize * sizeof(char*));
    memcpy(ranks, score, sizeof(ranks));
    qsort(ranks, scoreSize, sizeof(int), compare);
    for (i = 0; i < scoreSize; ++i) {
        rank = binSearch(ranks, scoreSize, score[i]);
        switch(rank) {
            case 0:
                placements[i] = strdup("Gold Medal");
                break;
            case 1:
                placements[i] = strdup("Silver Medal");
                break;
            case 2:
                placements[i] = strdup("Bronze Medal");
                break;
            default:
                placements[i] = (char*) malloc(6 * sizeof(char));
                sprintf(placements[i], "%d", rank+1);
        }
    }
    *returnSize = scoreSize;
    return placements;
}

int binSearch(int *a, int n, int val) {
    int lo = 0, mid, hi = n-1;
    while (lo <= hi) {
        mid = (lo + hi) >> 1;
        if (a[mid] == val) break;
        if (a[mid] < val) hi = mid - 1;
        else lo = mid + 1;
    }
    return mid;
}
