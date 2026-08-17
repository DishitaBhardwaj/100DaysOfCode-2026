bool canMakeArithmeticProgression(int* arr, int arrSize){
    for (int i=0;i<arrSize-1;i++){
        for (int j=i+1;j<arrSize;j++){
            if (arr[i]>arr[j]){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }

    int diff=arr[1]-arr[0];

    for (int i=2;i<arrSize;i++){
        if (arr[i]-arr[i-1]!=diff){
            return false;
        }
    }
    return true;
}
