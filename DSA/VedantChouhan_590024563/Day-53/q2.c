#include <stdio.h>
#include <string.h>

int main() {

    char log[10001], pattern[10001];

    printf("Enter log string: ");
    scanf("%s", log);

    printf("Enter pattern string: ");
    scanf("%s", pattern);

    int n = strlen(log);
    int m = strlen(pattern);

    int patternFreq[26] = {0};
    int windowFreq[26] = {0};

    for (int i = 0; i < m; i++) {
        patternFreq[pattern[i] - 'a']++;
        windowFreq[log[i] - 'a']++;
    }

    int found = 0;

    printf("Starting indices: ");

    for (int i = 0; i <= n - m; i++) {

        int same = 1;

        for (int j = 0; j < 26; j++) {
            if (patternFreq[j] != windowFreq[j]) {
                same = 0;
                break;
            }
        }

        if (same) {
            printf("%d ", i);
            found = 1;
        }

        if (i < n - m) {
            windowFreq[log[i] - 'a']--;
            windowFreq[log[i + m] - 'a']++;
        }
    }

    if (!found) {
        printf("No anagrams found");
    }

    printf("\n");

    return 0;
}