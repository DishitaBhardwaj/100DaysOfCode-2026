#include <stdio.h>
#include <stdbool.h>

bool areOccurrencesEqual(char s[]) {
    int freq[26] = {0};

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

    for (int i = 0; i < 26; i++) {
        if (freq[i] != 0 && freq[i] != expected) {
            return false;
        }
    }

    return true;
}

int main() {
    char s[1001];

    printf("Enter the string: ");
    scanf("%1000s", s);

    if (areOccurrencesEqual(s))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}