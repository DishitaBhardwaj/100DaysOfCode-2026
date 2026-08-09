import java.util.Scanner;
class Question2 
{
    static long merge(int[] arr, int low, int mid, int high) 
    {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        long count = 0;

        while (i <= mid && j <= high) 
        {
            if (arr[i] <= arr[j]) 
            {
                temp[k++] = arr[i++];
            } 
            else 
            {
                temp[k++] = arr[j++];
                count += (mid - i + 1);
            }
        }

        while (i <= mid) 
        {
            temp[k++] = arr[i++];
        }

        while (j <= high) 
        {
            temp[k++] = arr[j++];
        }

        for (i = low, k = 0; i <= high; i++, k++) 
        {
            arr[i] = temp[k];
        }

        return count;
    }

    static long mergeSort(int[] arr, int low, int high) 
    {
        if (low >= high) 
            return 0;

        int mid = low + (high - low) / 2;
        long count = 0;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);

        return count;
    }

    static long countInversions(int[] arr) 
    {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt();
        }
        long result = countInversions(arr);
        System.out.println("Total number of inversions: " + result);

        sc.close();
    }
}