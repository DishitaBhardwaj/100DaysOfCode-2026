#include <stdio.h>
#include <string.h>

int main() {
    int n;
    printf("Enter the size of the list:");
    scanf("%d", &n);
    char names[1000][100];
    int count[1000]={0};
    int size=0;
    char input[100];
    for (int i=0;i<n;i++){
        printf("Enter the username:");
        scanf("%s", input);
        int found=-1;
        for (int j=0;j<size;j++){
            if (strcmp(names[j],input)==0){
                found=j;
                break;
            }
        }
        if (found==-1){
            strcpy(names[size], input);
            count[size]=1;
            size++;
            printf("OK\n");
        } else {
            char newname[120];
            sprintf(newname, "%s%d", input, count[found]);
            printf("%s\n", newname);
            count[found]++;
            strcpy(names[size], newname);
            count[size]=1;
            size++;
        }
    }
    return 0;
}
