// Leetcode Problem 1502
// Can Make Arithmetic Progression From Sequence 

bool canMakeArithmeticProgression(int* arr, int arrSize) {
    for(int i = 1; i < arrSize; i++) {
        int temp = arr[i];
        int j = i - 1;
        while(j >= 0 && arr[j] > temp) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = temp;
    }
    int diff = arr[1] - arr[0];
    for(int i = 2; i < arrSize; i++) {
        if(arr[i] - arr[i - 1] != diff) {
            return false;
        }
    }
    return true;
}