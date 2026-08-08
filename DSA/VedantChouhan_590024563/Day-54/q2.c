#include <stdio.h>
#include <string.h>

int main() {

    int n;

    printf("Enter the number of goals: ");
    scanf("%d", &n);

    char team1[11] = "";
    char team2[11] = "";
    char goal[11];

    int count1 = 0, count2 = 0;

    printf("Enter the team names for each goal:\n");

    for (int i = 0; i < n; i++) {

        scanf("%s", goal);

        if (strlen(team1) == 0) {
            strcpy(team1, goal);
            count1++;
        }
        else if (strcmp(goal, team1) == 0) {
            count1++;
        }
        else if (strlen(team2) == 0) {
            strcpy(team2, goal);
            count2++;
        }
        else {
            count2++;
        }
    }

    if (count1 > count2)
        printf("Winning Team: %s\n", team1);
    else
        printf("Winning Team: %s\n", team2);

    return 0;
}