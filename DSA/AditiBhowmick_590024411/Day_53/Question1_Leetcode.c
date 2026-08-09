#include <stdio.h>
#include <string.h>

int main() {
    char s[101];

    printf("Enter the string: ");
    scanf("%s", s);

    int n = strlen(s);
    int count = 0;

    for (int i = 0; i <= n - 3; i++) {
        if (s[i] != s[i + 1] &&
            s[i] != s[i + 2] &&
            s[i + 1] != s[i + 2]) {
            count++;
        }
    }

    printf("Number of good substrings: %d\n", count);
    return 0;
}