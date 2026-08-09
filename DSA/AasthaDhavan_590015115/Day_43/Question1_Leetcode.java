class Solution {
    private void swap(int[] a1,int[] a2,int i1,int i2){
        if(a1[i1]>a2[i2]){
            int temp=a1[i1];
            a1[i1]=a2[i2];
            a2[i2]=temp;
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len=n+m;
        int gap=(len/2)+(len%2);
        while(gap>0){
            int l=0;
            int r=l+gap;
            while(r<len){
                if(l<m && r>=m){
                    swap(nums1,nums2,l,r-m);
                } else if(l>=m){
                    swap(nums2,nums2,l-m,r-m);
                } else{
                    swap(nums1,nums1,l,r);
                } l++;
                r++;

            }
         if(gap==1) break;
                gap=(gap/2)+(gap%2);
        }

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        } 
    }
}