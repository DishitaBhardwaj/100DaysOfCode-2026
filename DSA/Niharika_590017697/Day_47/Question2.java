import java.util.*;
class Question2
{
    static int kthSmallest(int[] A, int[] B, int k)
    {
        if(A.length > B.length)
            return kthSmallest(B, A, k);
        int n = A.length;
        int m = B.length;
        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while(low <= high)
        {
            int cutA = (low + high) / 2;
            int cutB = k - cutA;
            int leftA = (cutA == 0) ? Integer.MIN_VALUE : A[cutA - 1];
            int leftB = (cutB == 0) ? Integer.MIN_VALUE : B[cutB - 1];
            int rightA = (cutA == n) ? Integer.MAX_VALUE : A[cutA];
            int rightB = (cutB == m) ? Integer.MAX_VALUE : B[cutB];

            if(leftA <= rightB && leftB <= rightA)
            {
                return Math.max(leftA, leftB);
            }
            else if(leftA > rightB)
            {
                high = cutA - 1;
            }
            else
            {
                low = cutA + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array A: ");
        int n = sc.nextInt();
        int[] A = new int[n];
        System.out.println("Enter elements of sorted array A:");
        for(int i = 0; i < n; i++)
        {
            A[i] = sc.nextInt();
        }
        System.out.print("Enter size of array B: ");
        int m = sc.nextInt();
        int[] B = new int[m];
        System.out.println("Enter elements of sorted array B:");
        for(int i = 0; i < m; i++)
        {
            B[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = kthSmallest(A, B, k);
        System.out.println("The " + k + "-th smallest element is: " + result);

        sc.close();
    }
}