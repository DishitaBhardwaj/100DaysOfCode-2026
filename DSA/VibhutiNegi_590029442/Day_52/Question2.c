#include <stdio.h>
#include <string.h>
#define MAX 100000
#define LEN 40
typedef struct {
    char name[LEN];
    int count;
} User;
User users[MAX];
int size = 0;
int find(char *s) {
    for (int i = 0; i < size; i++) {
        if (strcmp(users[i].name, s) == 0)
            return i;
    }
    return -1;
}
int main() {
    int n;
    scanf("%d", &n);
    char s[LEN];
    for (int i = 0; i < n; i++) {
        scanf("%s", s);
        int idx = find(s);
        if (idx == -1) {
            printf("OK\n");
            strcpy(users[size].name, s);
            users[size].count = 1;
            size++;
        } else {
            char newName[LEN];
            sprintf(newName, "%s%d", s, users[idx].count);
            printf("%s\n", newName);
            users[idx].count++;
            strcpy(users[size].name, newName);
            users[size].count = 1;
            size++;
        }
    }
    return 0;
}