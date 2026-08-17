#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* printer(char* jobs){
    int n=strlen(jobs);

    int* queues=(int*)malloc(sizeof(int) * n);
    int* queuem=(int*)malloc(sizeof(int) * n);

    int fronts=0, rears=0;
    int frontm=0,rearm=0;

    for (int i=0;i<n;i++){
        if (jobs[i]=='S'){
            queues[rears++]=i;
        }else{
            queuem[rearm++]=i;
        }
    }

    while (fronts<rears&&frontm<rearm){
        int sindex=queues[fronts++];
        int mindex=queuem[frontm++];

        if (sindex<mindex){
            queues[rears++]=sindex+n;
        }else{
            queuem[rearm++]=mindex+n;
        }
    }
    free(queues);
    free(queuem);
    if (fronts<rears){
        return "Sales";
    }else{
        return "Marketing";
    }
}

int main(){
    char jobs[1000];
    printf("Enter jobs string (S for Sales, M for Marketing): ");
    scanf("%s", jobs);
    char* result=printer(jobs);
    printf("Winning Department: %s\n", result);
    return 0;
}
