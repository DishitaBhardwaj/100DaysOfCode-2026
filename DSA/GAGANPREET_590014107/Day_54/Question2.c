#include <stdio.h>
#include <string.h>

#define MAX_TEAMS 100
#define MAX_NAME 50

typedef struct {
    char name[MAX_NAME];
    int goals;
} Team;

char* winner(char goals[][MAX_NAME], int n) {
    static char result[MAX_NAME];
    Team teams[MAX_TEAMS];
    int teamCount = 0;

    for (int i = 0; i < n; i++) {
        int found = 0;

        for (int j = 0; j < teamCount; j++) {
            if (strcmp(teams[j].name, goals[i]) == 0) {
                teams[j].goals++;
                found = 1;
                break;
            }
        }

        if (!found) {
            strcpy(teams[teamCount].name, goals[i]);
            teams[teamCount].goals = 1;
            teamCount++;
        }
    }

    int maxGoals = 0;
    for (int i = 0; i < teamCount; i++) {
        if (teams[i].goals > maxGoals) {
            maxGoals = teams[i].goals;
            strcpy(result, teams[i].name);
        }
    }

    return result;
}

int main() {
    char goals[][MAX_NAME] = {"A", "ABA", "ABA", "A", "A"};
    int n = sizeof(goals) / sizeof(goals[0]);

    printf("%s\n", winner(goals, n));

    return 0;
}
