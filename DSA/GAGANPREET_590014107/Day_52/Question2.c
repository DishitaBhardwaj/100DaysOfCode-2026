#include <stdio.h>
#include <string.h>

#define MAX 100005
#define LEN 100

char usernames[MAX][LEN];
int count[MAX];

int main() {
    int n;
    scanf("%d", &n);

    int total = 0;

    while (n--) {
        char s[LEN];
        scanf("%s", s);

        int found = -1;

        // Search for username
        for (int i = 0; i < total; i++) {
            if (strcmp(usernames[i], s) == 0) {
                found = i;
                break;
            }
        }

        if (found == -1) {
            // Username is new
            printf("OK\n");
            strcpy(usernames[total], s);
            count[total] = 1;
            total++;
        } else {
            // Username already exists
            printf("%s%d\n", s, count[found]);
            count[found]++;
        }
    }

    return 0;
}
