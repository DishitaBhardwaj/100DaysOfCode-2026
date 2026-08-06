#include <stdio.h>
#include <string.h>

#define MAX 100000
#define LEN 35

int main() {
    int n;

    printf("Enter number of requests: ");
    scanf("%d", &n);

    char names[MAX][LEN];
    int count[MAX];

    int size = 0;

    printf("Enter usernames:\n");

    for (int i = 0; i < n; i++) {
        char s[LEN];
        scanf("%s", s);

        int found = -1;

        for (int j = 0; j < size; j++) {
            if (strcmp(names[j], s) == 0) {
                found = j;
                break;
            }
        }

        if (found == -1) {
            printf("OK\n");
            strcpy(names[size], s);
            count[size] = 1;
            size++;
        } else {
            printf("%s%d\n", s, count[found]);
            count[found]++;
        }
    }

    return 0;
}