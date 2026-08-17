#include <stdio.h>
#include <string.h>

void registerUsers(char names[][20], int n)
{
    char registered[100][25];
    int count = 0;

    for(int i = 0; i < n; i++)
    {
        int suffix = 0;

        for(int j = 0; j < count; j++)
        {
            if(strcmp(names[i], registered[j]) == 0)
                suffix++;
        }

        if(suffix == 0)
        {
            printf("OK\n");
            strcpy(registered[count], names[i]);
        }
        else
        {
            sprintf(registered[count], "%s%d", names[i], suffix);
            printf("%s\n", registered[count]);
        }

        count++;
    }
}

int main()
{
    char names[][20] = {
        "abacaba",
        "acaba",
        "abacaba",
        "acab"
    };

    int n = sizeof(names) / sizeof(names[0]);

    registerUsers(names, n);

    return 0;
}