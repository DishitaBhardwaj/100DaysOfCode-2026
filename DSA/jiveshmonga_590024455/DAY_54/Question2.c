#include <stdio.h>
#include <string.h>
char* winner(char *teams[],int n) 
{
    char *team1=teams[0];
    char *team2=NULL;
    int count1=0,count2=0;
    for (int i=0;i<n;i++) {
        if (strcmp(teams[i],team1)==0) 
        {
            count1++;
        } 
        else 
        {
            if (team2==NULL)
                team2=teams[i];
            count2++;
        }
    }
    return (count1 > count2) ? team1 : team2;
}
int main() 
{
    char *teams[] = {"A","ABA","ABA","A","A"};
    int n=sizeof(teams)/sizeof(teams[0]);
    printf("Winner: %s\n", winner(teams,n));
    return 0;
}