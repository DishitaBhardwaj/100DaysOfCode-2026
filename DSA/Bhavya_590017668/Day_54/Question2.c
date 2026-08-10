#include <string.h>

char* winningTeam(char** teams, int teamsSize) {
    int maxCount = 0;
    char* winner = NULL;

    for (int i = 0; i < teamsSize; i++) {
        int count = 0;
        for (int j = 0; j < teamsSize; j++) {
            if (strcmp(teams[i], teams[j]) == 0)
                count++;
        }
        if (count > maxCount) {
            maxCount = count;
            winner = teams[i];
        }
    }
    return winner;
}