#include <stdlib.h>
#include <string.h>

int* findAnagrams(char* log, char* pattern, int* returnSize) {
    int n = strlen(log), m = strlen(pattern);
    *returnSize = 0;

    if (m > n)
        return NULL;

    int freqP[26] = {0}, freqW[26] = {0};

    for (int i = 0; i < m; i++) {
        freqP[pattern[i] - 'a']++;
        freqW[log[i] - 'a']++;
    }

    int *ans = (int*)malloc((n - m + 1) * sizeof(int));

    if (memcmp(freqP, freqW, sizeof(freqP)) == 0)
        ans[(*returnSize)++] = 0;

    for (int i = m; i < n; i++) {
        freqW[log[i] - 'a']++;
        freqW[log[i - m] - 'a']--;

        if (memcmp(freqP, freqW, sizeof(freqP)) == 0)
            ans[(*returnSize)++] = i - m + 1;
    }

    return ans;
}