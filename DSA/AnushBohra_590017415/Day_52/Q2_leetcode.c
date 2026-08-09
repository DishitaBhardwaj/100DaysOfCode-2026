#include <stdio.h>
#include <stdbool.h>

bool areOccurrencesEqual(char* s) {
    int freq[26] = {0};
    
    
    for (int i = 0; s[i] != '\0'; i++) {
        freq[s[i] - 'a']++;
    }
    
    int target = 0;
    
    for (int i = 0; i < 26; i++) {
        if (freq[i] > 0) {
            if (target == 0) {
                target = freq[i]; 
            } else if (freq[i] != target) {
                return false;
            }
        }
    }
    
    return true;
}

int main(void) {
    char str1[] = "abacbc";
    printf("Input: %s -> Output: %s\n", str1, areOccurrencesEqual(str1) ? "true" : "false");

    char str2[] = "aaabb";
    printf("Input: %s -> Output: %s\n", str2, areOccurrencesEqual(str2) ? "true" : "false");

    return 0;
}