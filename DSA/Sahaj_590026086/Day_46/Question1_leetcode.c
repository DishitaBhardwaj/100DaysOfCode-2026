int* intersection(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {
    int* result=(int*)malloc(sizeof(int)*(nums1Size<nums2Size?nums1Size:nums2Size));
    int count=0;

    for (int i=0;i<nums1Size;i++){
        int found=0;
        for (int k=0;k<count;k++){
            if (result[k]==nums1[i]){
                found=1;
                break;
            }
        }
        if (found) continue;
        for (int j=0; j<nums2Size;j++){
            if (nums1[i]==nums2[j]){
                result[count++]=nums1[i];
                break;
            }
        }
    }

    *returnSize=count;
    return result;
}
