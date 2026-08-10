#include <stdio.h>
#include <string.h>

#define MAX 105
#define LEN 35

char* winner(char goals[][LEN], int n)
{
    static char team1[LEN], team2[LEN];

    strcpy(team1, goals[0]);

    int count1 = 1, count2 = 0;

    for (int i = 1; i < n; i++)
    {
        if (strcmp(goals[i], team1) == 0)
            count1++;
        else
        {
            strcpy(team2, goals[i]);
            count2++;
        }
    }

    if (count1 > count2)
        return team1;

    return team2;
}

int main()
{
    int n;
    scanf("%d", &n);

    char goals[MAX][LEN];

    for (int i = 0; i < n; i++)
        scanf("%s", goals[i]);

    printf("%s\n", winner(goals, n));

    return 0;
}