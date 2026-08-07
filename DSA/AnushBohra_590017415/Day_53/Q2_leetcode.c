#include <stdio.h>
#include <string.h>

int countGoodSubstrings(char* s) {
    int count = 0;
    int len = strlen(s);

    for (int i = 0; i <= len - 3; i++) {
        if (s[i] != s[i + 1] && s[i + 1] != s[i + 2] && s[i] != s[i + 2]) {
            count++;
        }
    }

    return count;
}

int main(void) {
    // Test Case 1
    char str1[] = "xyzzaz";
    printf("Input: %s -> Output: %d\n", str1, countGoodSubstrings(str1)); 
    // Expected output: 1 ("xyz")

    // Test Case 2
    char str2[] = "aababcabc";
    printf("Input: %s -> Output: %d\n", str2, countGoodSubstrings(str2)); 
    // Expected output: 4 ("abc", "bca", "cab", "abc")

    return 0;
}