import java.util.Scanner;

public class Main {

    public static int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];

        for (int num : nums) {
            freq[num]++;
        }

        int maxFreq = 0;

        for (int i = 1; i <= 100; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
            }
        }

        int total = 0;

        for (int i = 1; i <= 100; i++) {
            if (freq[i] == maxFreq) {
                total += freq[i];
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = maxFrequencyElements(nums);

        System.out.println("Total maximum frequency: " + result);

        sc.close();
    }
}