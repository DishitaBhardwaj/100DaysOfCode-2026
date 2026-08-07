#include <stdio.h>
#include <string.h>

int main() {
    char log[10001], pattern[10001];

    printf("Enter log: ");
    scanf("%s", log);

    printf("Enter pattern: ");
    scanf("%s", pattern);

    int n = strlen(log);
    int m = strlen(pattern);

    int freqP[26] = {0};
    int freqW[26] = {0};

    for (int i = 0; i < m; i++) {
        freqP[pattern[i] - 'a']++;
        freqW[log[i] - 'a']++;
    }

    printf("[");

    int first = 1;

    for (int i = 0; i <= n - m; i++) {

        int same = 1;
        for (int j = 0; j < 26; j++) {
            if (freqP[j] != freqW[j]) {
                same = 0;
                break;
            }
        }

        if (same) {
            if (!first)
                printf(", ");
            printf("%d", i);
            first = 0;
        }

        if (i < n - m) {
            freqW[log[i] - 'a']--;
            freqW[log[i + m] - 'a']++;
        }
    }

    printf("]\n");

    return 0;
}