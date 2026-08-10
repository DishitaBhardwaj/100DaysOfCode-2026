#include <stdio.h>
#include <string.h>

int countGoodSubstrings(char s[]) {
    int n = strlen(s);

    if (n < 3)
        return 0;

    int count = 0;

    for (int i = 0; i <= n - 3; i++) {
        if (s[i] != s[i + 1] &&
            s[i] != s[i + 2] &&
            s[i + 1] != s[i + 2]) {
            count++;
        }
    }

    return count;
}

int main() {
    char s[101];

    printf("Enter the string: ");
    scanf("%100s", s);

    printf("Number of good substrings: %d\n", countGoodSubstrings(s));

    return 0;
}