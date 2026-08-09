int* intersection(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {
    int visit[1001] = {0};
    int used[1001] = {0};
    int limit;
    if (nums1Size < nums2Size)
        limit = nums1Size;
    else
        limit = nums2Size;
    int *ans = (int *)malloc(limit * sizeof(int));
    int index = 0;
    for (int i = 0; i < nums1Size; i++) {
        visit[nums1[i]] = 1;
    }
    for (int i = 0; i < nums2Size; i++) {
        int x = nums2[i];
        if (visit[x] && !used[x]) {
            ans[index] = x;
            index++;
            used[x] = 1;
        }
    }
    *returnSize = index;
    return ans;
}