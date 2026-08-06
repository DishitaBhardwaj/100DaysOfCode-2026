#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

/**
 * Helper function to check if two frequency arrays of size 26 are identical.
 */
bool matches(const int freq1[], const int freq2[]) {
    for (int i = 0; i < 26; i++) {
        if (freq1[i] != freq2[i]) {
            return false;
        }
    }
    return true;
}

/**
 * Finds all starting indices of anagrams of pattern in log.
 * 
 * @param log The input log string.
 * @param pattern The target pattern string.
 * @param returnSize Pointer to store the number of found indices.
 * @return Dynamically allocated array containing the starting indices.
 */
int* findAnagrams(const char* log, const char* pattern, int* returnSize) {
    int logLen = strlen(log);
    int patLen = strlen(pattern);
    
    *returnSize = 0;

    // Edge case: pattern length is larger than log length
    if (patLen > logLen || patLen == 0) {
        return NULL;
    }

    // Allocate maximum possible space for result indices
    int* result = (int*)malloc(logLen * sizeof(int));
    if (!result) return NULL;

    int patternFreq[26] = {0};
    int windowFreq[26] = {0};

    // Populate frequency array for pattern and initial window of log
    for (int i = 0; i < patLen; i++) {
        patternFreq[pattern[i] - 'a']++;
        windowFreq[log[i] - 'a']++;
    }

    // Check the first window
    if (matches(patternFreq, windowFreq)) {
        result[(*returnSize)++] = 0;
    }

    // Slide the window across log
    for (int i = patLen; i < logLen; i++) {
        // Add current character to window
        windowFreq[log[i] - 'a']++;
        
        // Remove left-most character of previous window
        windowFreq[log[i - patLen] - 'a']--;

        // Check if current window matches target pattern frequency
        if (matches(patternFreq, windowFreq)) {
            result[(*returnSize)++] = i - patLen + 1;
        }
    }

    return result;
}

int main() {
    const char* log = "cbaebabacd";
    const char* pattern = "abc";
    int returnSize = 0;

    int* indices = findAnagrams(log, pattern, &returnSize);

    printf("Output: [");
    for (int i = 0; i < returnSize; i++) {
        printf("%d%s", indices[i], (i == returnSize - 1) ? "" : ", ");
    }
    printf("]\n");

    // Clean up allocated memory
    free(indices);

    return 0;
}