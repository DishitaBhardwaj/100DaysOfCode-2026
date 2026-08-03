// Problem 2
// Assembly via Minimums 

#include <stdio.h>

void merge(int arr[], int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int L[n1], R[n2];

    for(int i = 0; i < n1; i++)
        L[i] = arr[left + i];

    for(int i = 0; i < n2; i++)
        R[i] = arr[mid + 1 + i];
        
    int i = 0, j = 0, k = left;
    while(i < n1 && j < n2) {
        if(L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        }
        else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    while(i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
    while(j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

void mergeSort(int arr[], int left, int right) {
    if(left < right) {
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
}

int main() {
    int n;
    printf("Enter size of original array: ");
    scanf("%d", &n);
    int size = n * (n - 1) / 2;
    int b[size];
    printf("Enter %d elements of array b: ", size);
    for(int i = 0; i < size; i++)
        scanf("%d", &b[i]);
    mergeSort(b, 0, size - 1);
    int a[n];
    int index = 0;
    for(int i = 0; i < n - 1; i++) {
        a[i] = b[index];
        index = index + (n - i - 1);
    }
    a[n - 1] = a[n - 2];
    printf("One possible original array is: ");
    for(int i = 0; i < n; i++)
        printf("%d ", a[i]);
    return 0;
}