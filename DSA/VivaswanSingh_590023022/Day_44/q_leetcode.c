bool canMakeArithmeticProgression(int* arr, int arrSize) {
    int min_val = arr[0];
    int max_val = arr[0];
    
    for (int i = 1; i < arrSize; i++) {
        if (arr[i] < min_val) min_val = arr[i];
        if (arr[i] > max_val) max_val = arr[i];
    }
    
    if ((max_val - min_val) % (arrSize - 1) != 0) return false;
    
    int diff = (max_val - min_val) / (arrSize - 1);
    if (diff == 0) return true;
    
    int i = 0;
    while (i < arrSize) {
        if (arr[i] == min_val + i * diff) {
            i++;
        } else if ((arr[i] - min_val) % diff != 0) {
            return false;
        } else {
            int j = (arr[i] - min_val) / diff;
            if (arr[i] == arr[j]) return false;
            
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    return true;
}