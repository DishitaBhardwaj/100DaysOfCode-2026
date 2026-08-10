#include <string.h>

char* winner(char goals[][20], int n)
{
    int count = 0;

    for(int i = 0; i < n; i++)
    {
        if(strcmp(goals[i], goals[0]) == 0)
            count++;
        else
            count--;
    }

    if(count > 0)
        return goals[0];

    for(int i = 0; i < n; i++)
    {
        if(strcmp(goals[i], goals[0]) != 0)
            return goals[i];
    }

    return goals[0];
}