// Problem 2 
// Count Inversions in an Array 

#include <stdio.h>

int merge(int arr[], int left, int middle, int right) {
    int size1 = middle - left + 1;
    int size2 = right - middle;
    int leftArray[size1];
    int rightArray[size2];
    int i, j, k;
    int count = 0;

    for(i = 0; i < size1; i++) {
        leftArray[i] = arr[left + i];
    }
    for(j = 0; j < size2; j++) {
        rightArray[j] = arr[middle + 1 + j];
    }

    i = 0;
    j = 0;
    k = left;
    while(i < size1 && j < size2) {
        if(leftArray[i] <= rightArray[j]) {
            arr[k] = leftArray[i];
            i++;
        }
        else{
            arr[k] = rightArray[j];
            count = count + (size1 - i);
            j++;
        }
        k++;
    }

    while(i < size1) {
        arr[k] = leftArray[i];
        i++;
        k++;
    }

    while(j < size2) {
        arr[k] = rightArray[j];
        j++;
        k++;
    }

    return count;
}

int mergeSort(int arr[], int left, int right) {
    if(left >= right) {
        return 0;
    }

    int middle = (left + right) / 2;
    int count = 0;

    count = count + mergeSort(arr, left, middle);
    count = count + mergeSort(arr, middle + 1, right);
    count = count + merge(arr, left, middle, right);

    return count;
}

int main() {
    int length;
    int i;
    printf("Enter the length of the array: ");
    scanf("%d", &length);
    int arr[length];
    printf("Enter %d elements: ", length);
    for (i = 0; i < length; i++) {
        scanf("%d", &arr[i]);
    }

    int answer = mergeSort(arr, 0, length - 1);
    printf("Total inversions = %d ", answer);
    
    return 0;
}