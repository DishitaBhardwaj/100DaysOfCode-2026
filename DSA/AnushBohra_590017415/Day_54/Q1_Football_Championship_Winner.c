#include <stdio.h>
#include <string.h>

#define MAX_TEAMS 100
#define MAX_NAME_LEN 50

typedef struct {
    char name[MAX_NAME_LEN];
    int score;
} Team;

char* footballChampionshipWinner(char goals[][MAX_NAME_LEN], int goalsSize) {
    Team teams[MAX_TEAMS];
    int teamCount = 0;

    for (int i = 0; i < goalsSize; i++) {
        int found = 0;
        
        // Check if team already exists in our table
        for (int j = 0; j < teamCount; j++) {
            if (strcmp(teams[j].name, goals[i]) == 0) {
                teams[j].score++;
                found = 1;
                break;
            }
        }
        
        // Add new team if not found
        if (!found) {
            strcpy(teams[teamCount].name, goals[i]);
            teams[teamCount].score = 1;
            teamCount++;
        }
    }

    // Find the team with the maximum goals
    int maxGoals = -1;
    int winnerIndex = 0;
    for (int i = 0; i < teamCount; i++) {
        if (teams[i].score > maxGoals) {
            maxGoals = teams[i].score;
            winnerIndex = i;
        }
    }

    return teams[winnerIndex].name;
}

int main() {
    char goals[][MAX_NAME_LEN] = {"A", "ABA", "ABA", "A", "A"};
    int goalsSize = sizeof(goals) / sizeof(goals[0]);

    char* winner = footballChampionshipWinner(goals, goalsSize);
    printf("Winning Team: %s\n", winner); // Expected Output: "A"

    return 0;
}