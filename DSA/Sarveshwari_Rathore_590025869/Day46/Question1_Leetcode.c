int compare(const void *a, const void *b){
    return (*(int *)a - *(int *)b);
}
int binarysearch(int arr[], int size, int target){
    int low = 0;
    int high = size - 1;
    while(low <= high){
        int mid = low + (high - low) / 2;
        if(arr[mid] == target){
            return 1;
        }
        if(arr[mid] < target){
            low = mid + 1;
        } else{
            high = mid - 1;
        }
    }return 0;
}
int *intersection(int *nums1, int nums1Size,int *nums2, int nums2Size,int *returnSize) {
    qsort(nums2,nums2Size,sizeof(int),compare);
    int size = (nums1Size<nums2Size) ? nums1Size:nums2Size;
    int *result = (int *)malloc(sizeof(int)*size);
    int k=0;
    for (int i=0; i<nums1Size;i++){
        int duplicate=0;
        for (int j=0; j<k;j++){
            if(result[j] == nums1[i]){
                duplicate = 1;
                break;
            }
        } if(duplicate){
            continue;
        }
        int found = binarysearch(nums2, nums2Size, nums1[i]);
        if(found){
            result[k++] = nums1[i];
        }
    }
    *returnSize = k;
    return result;
}