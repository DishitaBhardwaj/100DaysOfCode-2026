
#include <stdlib.h>
int* intersection(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {
    int present1[1001]={0};
    int present2[1001]={0};
    for (int i=0;i<nums1Size;i++)
        present1[nums1[i]]=1;
    for (int i = 0; i < nums2Size; i++)
        present2[nums2[i]]=1;
    int *result = (int *)malloc(1001 * sizeof(int));
    int k=0;
    for (int i=0;i<=1000;i++) {
        if (present1[i]&&present2[i]) {
            result[k++]=i;
        }
    }
    *returnSize = k;
    return result;
}