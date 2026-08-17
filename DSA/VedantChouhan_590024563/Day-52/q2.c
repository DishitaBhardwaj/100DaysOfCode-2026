#include <stdio.h>
#include <string.h>

#define MAX 100000
#define LEN 33

char usernames[MAX][LEN];
int count[MAX];

int main() {

    int n;

    printf("Enter number of requests: ");
    scanf("%d", &n);

    char request[LEN];

    for (int i = 0; i < n; i++) {

        scanf("%s", request);

        int found = -1;

        for (int j = 0; j < i; j++) {

            if (strcmp(usernames[j], request) == 0) {
                found = j;
                break;
            }
        }

        if (found == -1) {

            printf("OK\n");

            strcpy(usernames[i], request);
            count[i] = 1;
        }

        else {

            char newName[50];

            sprintf(newName, "%s%d", request, count[found]);

            printf("%s\n", newName);

            count[found]++;

            strcpy(usernames[i], newName);
            count[i] = 1;
        }
    }

    return 0;
}