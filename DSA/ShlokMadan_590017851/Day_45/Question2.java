public class Question2 
{
    static long mergeSort(int[] arr,int left,int right) 
    {
        long count=0;
        if(left<right) 
            {
            int mid=left+(right-left)/2;
            count+=mergeSort(arr,left,mid);
            count+=mergeSort(arr,mid+1,right);
            count+=merge(arr,left,mid,right);
        }
        return count;
    }
    static long merge(int[] arr,int left,int mid,int right) 
    {
        int n1=mid-left+1;
        int n2=right-mid;
        int[] L=new int[n1];
        int[] R=new int[n2];
        for(int i=0;i<n1;i++) 
            {
            L[i]=arr[left+i];
        }
        for(int i=0;i<n2;i++) 
            {
            R[i]=arr[mid+1+i];
        }
        int i=0;
        int j=0;
        int k=left;
        long count=0;
        while(i<n1 && j<n2) 
            {
            if(L[i]<=R[j]) 
                {
                arr[k++]=L[i++];
            }
            else 
                {
                arr[k++]=R[j++];
                count+=n1-i;
            }
        }
        while(i<n1) 
            {
            arr[k++]=L[i++];
        }
        while(j<n2) 
            {
            arr[k++]=R[j++];
        }
        return count;
    }
    public static void main(String[] args) 
    {
        int[] arr={2,4,1,3,5};
        System.out.println(mergeSort(arr,0,arr.length-1));
    }
}