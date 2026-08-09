
class SE{
    public static int kthSmallest(int[] A, int[] B, int k){
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < A.length && j < B.length){
            if(A[i] < B[j]){
                count++;
                if (count == k)
                    return A[i];

                i++;
            }
            else{
                count++;
                if(count == k)
                    return B[j];

                j++;
            }
        }
        while(i < A.length){
            count++;
            if(count == k)
                return A[i];

            i++;
        }
        while(j < B.length){
            count++;
            if(count == k)
                return B[j];

            j++;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] A = {2, 3, 6, 7};
        int[] B = {1, 4, 5, 8};
        int k = 3;
        System.out.println("K-th Smallest Element = " + kthSmallest(A, B, k));
    }
}