#include <stdio.h>
#include <string.h>

void findAnagrams(char *log, char *pattern) {
    int n = strlen(log);
    int m = strlen(pattern);

    if (m > n) return;

    int freqP[26] = {0};
    int freqW[26] = {0};

    // Frequency of pattern
    for (int i = 0; i < m; i++) {
        freqP[pattern[i] - 'a']++;
        freqW[log[i] - 'a']++;
    }

    // Check first window
    if (memcmp(freqP, freqW, sizeof(freqP)) == 0)
        printf("%d ", 0);

    // Slide the window
    for (int i = m; i < n; i++) {
        freqW[log[i] - 'a']++;          // Add new character
        freqW[log[i - m] - 'a']--;      // Remove old character

        if (memcmp(freqP, freqW, sizeof(freqP)) == 0)
            printf("%d ", i - m + 1);
    }
}

int main() {
    char log[] = "cbaebabacd";
    char pattern[] = "abc";

    printf("Output: ");
    findAnagrams(log, pattern);

    return 0;
}
