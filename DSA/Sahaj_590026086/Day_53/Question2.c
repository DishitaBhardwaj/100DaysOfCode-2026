#include <stdio.h>
#include <string.h>

int main() {
    char log[1000], pattern[1000];
    printf("Enter the string:");
    scanf("%s", log);
    printf("Enter the pattern:");
    scanf("%s", pattern);

    int n=strlen(log);
    int m=strlen(pattern);

    int freqp[26]={0};
    int freqw[26]={0};
    for (int i=0;i<m;i++){
        freqp[pattern[i]-'a']++;
        freqw[log[i]-'a']++;   
    }

    int match=1;
    for (int i=0;i<26;i++){
        if (freqp[i]!=freqw[i]){
            match=0;
            break;
        }
    }
    if (match) printf("%d ", 0);

    for (int i=m;i<n;i++){
        freqw[log[i]-'a']++;         
        freqw[log[i-m]-'a']--;       

        match=1;
        for (int j=0;j<26;j++){
            if (freqp[j]!=freqw[j]) {
                match=0;
                break;
            }
        }
        if (match) printf("%d ", i-m+1);
    }
    return 0;
}
