#include <stdio.h>
#include <string.h>

int main() {
    char s[101];

    printf("Enter string: ");
    scanf("%s", s);

    int count = 0;
    int n = strlen(s);

    for (int i = 0; i <= n - 3; i++) {
        if (s[i] != s[i + 1] &&
            s[i] != s[i + 2] &&
            s[i + 1] != s[i + 2]) {
            count++;
        }
    }

    printf("%d\n", count);

    return 0;
}