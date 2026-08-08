#include <stdio.h>
#include <string.h>

int main(){
    int n;
    printf("Enter the number of goals:");
    scanf("%d", &n);
    char goals[1000][100];
    char teams[1000][100];
    int count[1000]={0};
    int size=0;
    for (int i=0;i<n;i++){
        printf("Enter the team name which scored the goal:");
        scanf("%s", goals[i]);
        int found=-1;
        for (int j=0;j<size;j++){
            if (strcmp(teams[j],goals[i])==0){
                found = j;
                break;
            }
        }
        if (found==-1){
            strcpy(teams[size], goals[i]);
            count[size]=1;
            size++;
        } else {
            count[found]++;
        }
    }
    int maxgoals=0;
    char winner[100];
    for (int i=0;i<size;i++){
        if (count[i]>maxgoals){
            maxgoals=count[i];
            strcpy(winner, teams[i]);
        }
    }
    printf("%s\n", winner);
    return 0;
}
