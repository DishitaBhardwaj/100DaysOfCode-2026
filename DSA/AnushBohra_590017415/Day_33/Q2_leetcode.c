#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* removeOuterParentheses(char* s) {
    int len = strlen(s);
    // Allocate memory for the result string (at most the same length as s + 1 for null-terminator)
    char* result = (char*)malloc((len + 1) * sizeof(char));
    int resIdx = 0;
    int opened = 0;

    for (int i = 0; i < len; i++) {
        if (s[i] == '(') {
            // If it's not the outermost opening parenthesis, add to result
            if (opened > 0) {
                result[resIdx++] = s[i];
            }
            opened++;
        } else if (s[i] == ')') {
            opened--;
            // If it's not the outermost closing parenthesis, add to result
            if (opened > 0) {
                result[resIdx++] = s[i];
            }
        }
    }
    
    // Null-terminate the string
    result[resIdx] = '\0';
    return result;
}

int main() {
    // Test Case 1
    char s1[] = "(()())(())";
    char* res1 = removeOuterParentheses(s1);
    printf("Input:  %s\nOutput: %s\n\n", s1, res1);
    free(res1);

    // Test Case 2
    char s2[] = "(()())(())(()(()))";
    char* res2 = removeOuterParentheses(s2);
    printf("Input:  %s\nOutput: %s\n\n", s2, res2);
    free(res2);

    // Test Case 3
    char s3[] = "()()";
    char* res3 = removeOuterParentheses(s3);
    printf("Input:  %s\nOutput: %s\n\n", s3, res3);
    free(res3);

    return 0;
}