#include <stdio.h>
#include <string.h>

char* winner(char goals[][20], int n)
{
    char team1[20], team2[20];
    int count1 = 0, count2 = 0;

    strcpy(team1, goals[0]);
    count1 = 1;

    for(int i = 1; i < n; i++)
    {
        if(strcmp(goals[i], team1) == 0)
        {
            count1++;
        }
        else
        {
            strcpy(team2, goals[i]);
            count2 = 1;

            for(int j = i + 1; j < n; j++)
            {
                if(strcmp(goals[j], team2) == 0)
                    count2++;
            }
            break;
        }
    }

    if(count1 > count2)
        return team1;
    else
        return team2;
}

int main()
{
    char goals[][20] = {"A", "ABA", "ABA", "A", "A"};
    int n = sizeof(goals) / sizeof(goals[0]);

    printf("%s\n", winner(goals, n));

    return 0;
}