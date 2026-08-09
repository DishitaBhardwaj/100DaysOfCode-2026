#include <stdlib.h>
#include <string.h>
#include <stdio.h>
typedef struct 
{
    int score;
    int index;
} Athlete;
int compare(const void *a, const void *b) 
{
    Athlete *x =(Athlete *)a;
    Athlete *y =(Athlete *)b;
    return y->score - x->score;   
}
char** findRelativeRanks(int* score, int scoreSize, int* returnSize) 
{
    *returnSize = scoreSize;
    Athlete *arr = (Athlete *)malloc(scoreSize * sizeof(Athlete));
    char **ans = (char **)malloc(scoreSize * sizeof(char *));
    for (int i=0;i<scoreSize;i++) 
    {
        arr[i].score=score[i];
        arr[i].index=i;
    }
    qsort(arr, scoreSize, sizeof(Athlete), compare);
    for (int i=0;i<scoreSize;i++) 
    {
        int idx=arr[i].index;
        if (i==0) 
        {
            ans[idx] =(char *)malloc(12);
            strcpy(ans[idx], "Gold Medal");
        }
        else if (i==1) 
        {
            ans[idx]=(char *)malloc(13);
            strcpy(ans[idx], "Silver Medal");
        }
        else if(i==2) \
        {
            ans[idx]=(char *)malloc(13);
            strcpy(ans[idx], "Bronze Medal");
        }
        else 
        {
            ans[idx]=(char *)malloc(12);
            sprintf(ans[idx], "%d",i+1);
        }
    }
    free(arr);
    return ans;
}