#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int* findAnagrams(char *log, char *pattern, int *returnSize) {
    int n = strlen(log);
    int m = strlen(pattern);

    *returnSize = 0;

    if (m > n)
        return NULL;

    int patFreq[26] = {0};
    int winFreq[26] = {0};

    for (int i = 0; i < m; i++) {
        patFreq[pattern[i] - 'a']++;
        winFreq[log[i] - 'a']++;
    }

    int *result = (int *)malloc((n - m + 1) * sizeof(int));

    for (int i = 0; i <= n - m; i++) {

        int match = 1;

        for (int j = 0; j < 26; j++) {
            if (patFreq[j] != winFreq[j]) {
                match = 0;
                break;
            }
        }

        if (match)
            result[(*returnSize)++] = i;

        if (i < n - m) {
            winFreq[log[i] - 'a']--;
            winFreq[log[i + m] - 'a']++;
        }
    }

    return result;
}

int main() {
    char log[10001], pattern[10001];

    printf("Enter log string: ");
    scanf("%10000s", log);

    printf("Enter pattern: ");
    scanf("%10000s", pattern);

    int size;
    int *ans = findAnagrams(log, pattern, &size);

    printf("Starting indices: ");

    for (int i = 0; i < size; i++)
        printf("%d ", ans[i]);

    printf("\n");

    free(ans);

    return 0;
}