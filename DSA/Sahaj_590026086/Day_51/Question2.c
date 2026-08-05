#include <stdio.h>
#include <string.h>

int main() {
    int n;
    printf("Enter the size of the array:");
    scanf("%d", &n);
    int vendor[1000], lot[1000];
    char cert[1000][50];

    for (int i=0;i<n;i++){
        printf("Enter Cendor ID, Slot number and Certificate Code separated by spaces:");
        scanf("%d %d %s", &vendor[i], &lot[i], cert[i]);
    }

    for (int i=0;i<n;i++){
        for (int j=0;j<i;j++){
            if (vendor[i]==vendor[j]&&lot[i]==lot[j]){
                if (strcmp(cert[i],cert[j])!=0){
                    printf("%d\n", i);
                    return 0;
                }
            }
        }
    }

    printf("-1\n");
    return 0;
}
