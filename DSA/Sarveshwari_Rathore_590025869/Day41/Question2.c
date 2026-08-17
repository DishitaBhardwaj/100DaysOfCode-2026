#include <stdio.h>
#include <string.h>

#define M 1000
int main() {
    char jobs[M];
    printf("Enterjobs: ");
    scanf("%s", jobs);
    int n =strlen(jobs);
    int sales[M], marketing[M];
    int sf=0, sr=-1;
    int mf=0, mr=-1;

    for(int i = 0; i < n; i++){
        if (jobs[i] == 'S')
            sales[++sr] = i;
        else if(jobs[i] == 'M')
            marketing[++mr] = i;
    }
    while(sf <= sr && mf <= mr){
        int s = sales[sf++];
        int m = marketing[mf++];
        if(s < m){
            sales[++sr] = s + n;
        }else{
            marketing[++mr] = m + n;
        }
    }
    if(sf <= sr){
        printf("Winning Department:Sales");
    }
    else{
        printf("Winning Department:Marketing");
    }
    return 0;
}