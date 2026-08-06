#include <stdio.h>
#include <string.h>

int main() {
    char s[1001];
    int freq[26] = {0};

    printf("Enter the string: ");
    scanf("%s", s);

    for (int i = 0; s[i] != '\0'; i++) {
        freq[s[i] - 'a']++;
    }

    int expected = 0;

    for (int i = 0; i < 26; i++) {
        if (freq[i] != 0) {
            expected = freq[i];
            break;
        }
    }

    int good = 1;

    for (int i = 0; i < 26; i++) {
        if (freq[i] != 0 && freq[i] != expected) {
            good = 0;
            break;
        }
    }

    if (good)
        printf("true\n");
    else
        printf("false\n");

    return 0;
}