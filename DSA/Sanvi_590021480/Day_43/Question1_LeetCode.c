void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n) {
    int end=nums1Size-1;

    while(n>0 && m>0){
        if(nums2[n-1]>=nums1[m-1]){
            nums1[end]=nums2[n-1];
            n--;
        }
        else {
            nums1[end]=nums1[m-1];
            m--;
        }
        end--;
    }
    while(n>0){
        nums1[end]=nums2[n-1];
        n--;
        end--;
    }
}
