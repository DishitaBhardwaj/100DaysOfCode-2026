#include <stdio.h>
#include <string.h>
char* winningTeam(char goals[][11], int n) {
    char team1[11] = "";
    char team2[11] = "";
    int count1 = 0;
    int count2 = 0;
    for (int i = 0; i < n; i++) {
        if (strcmp(team1, "") == 0) {
            strcpy(team1, goals[i]);
            count1++;
        }
        else if (strcmp(goals[i], team1) == 0) {
            count1++;
        }
        else {
            strcpy(team2, goals[i]);
            count2++;
        }
    }
    if (count1 > count2) {
        return team1;
    }
    return team2;
}
int main() {
    int n;
    scanf("%d", &n);
    char goals[100][11];
    for (int i = 0; i < n; i++) {
        scanf("%s", goals[i]);
    }
    printf("%s", winningTeam(goals, n));
    return 0;
}