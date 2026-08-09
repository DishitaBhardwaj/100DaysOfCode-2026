import java.util.Scanner;

public class Question2 {
     public static int maximizeSumOfPairMinimums(int[] arr) {
        int[] frequency = new int[20001];
        
        for (int num : arr) {
            frequency[num + 10000]++;
        }
        
        int sum = 0;
        boolean pickNext = true;
        
        for (int i = 0; i < frequency.length; i++) {
            while (frequency[i] > 0) {
                if (pickNext) {
                    sum += (i - 10000);
                }
                pickNext = !pickNext;
                frequency[i]--;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = maximizeSumOfPairMinimums(arr);
        System.out.println("Maximum possible sum of the minimum values of each pair: " + ans);
        sc.close();
    }
}