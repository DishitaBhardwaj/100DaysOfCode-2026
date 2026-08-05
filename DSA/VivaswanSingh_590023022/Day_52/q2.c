#include <stdio.h>
#include <string.h>

#define MAX 100005
#define LEN 35

typedef struct
{
    char name[LEN];
    int count;
} User;

User users[MAX];
int total = 0;

int findUser(char *name)
{
    for (int i = 0; i < total; i++)
    {
        if (strcmp(users[i].name, name) == 0)
            return i;
    }
    return -1;
}

void registerUser(char *name)
{
    int idx = findUser(name);

    if (idx == -1)
    {
        strcpy(users[total].name, name);
        users[total].count = 1;
        total++;

        printf("OK\n");
    }
    else
    {
        printf("%s%d\n", name, users[idx].count);
        users[idx].count++;
    }
}

int main()
{
    int n;
    scanf("%d", &n);

    char name[LEN];

    for (int i = 0; i < n; i++)
    {
        scanf("%s", name);
        registerUser(name);
    }

    return 0;
}