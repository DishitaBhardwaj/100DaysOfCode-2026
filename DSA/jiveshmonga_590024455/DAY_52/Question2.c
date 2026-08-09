#include <stdio.h>
#include <string.h>
int main() 
{
    int n;
    scanf("%d",&n);
    char names[1000][50];
    int count[1000];
    int size=0;
    for (int i=0;i<n;i++) {
        char s[50];
        scanf("%s",s);
        int found=-1;
        for (int j=0;j<size;j++) {
            if (strcmp(names[j],s)==0) {
                found=j;
                break;
            }
        }
        if(found==-1) 
        {
            strcpy(names[size],s);
            count[size]=1;
            size++;
            printf("OK\n");
        }
        else 
        {
            char newName[60];
            sprintf(newName, "%s%d", s, count[found]);
            count[found]++;
            strcpy(names[size], newName);
            count[size]=1;
            size++;
            printf("%s\n", newName);
        }
    }
    return 0;
}