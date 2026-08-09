// Problem 2 
// Maximum Prefix Difference Score 

#include <stdio.h>
void sort(int arr[], int n) {
    for(int i = 0; i < n - 1; i++) {
        for(int j = 0; j < n - i - 1; j++) {
            if(arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    int n;
    printf("Enter size: ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter elements: ");
    for(int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    sort(arr, n);
    int newArr[n];
    if(n == 1) {
        newArr[0] = arr[0];
    }
    else {
        newArr[0] = arr[0];
        newArr[1] = arr[n - 1];
        for(int i = 1; i < n - 1; i++) {
            newArr[i + 1] = arr[i];
        }
    }

    int minPrefix[n];
    int maxPrefix[n];
    minPrefix[0] = newArr[0];
    maxPrefix[0] = newArr[0];
    for(int i = 1; i < n; i++) {
        if(newArr[i] < minPrefix[i - 1]) {
            minPrefix[i] = newArr[i];
        }
        else {
            minPrefix[i] = minPrefix[i - 1];
        }
        if(newArr[i] > maxPrefix[i - 1]) {
            maxPrefix[i] = newArr[i];
        }
        else {
            maxPrefix[i] = maxPrefix[i - 1];
        }
    }

    int score = 0;
    for(int i = 0; i < n; i++) {
        score = score + (maxPrefix[i] - minPrefix[i]);
    }
    printf("Maximum Possible Score = %d", score);
    return 0;
}