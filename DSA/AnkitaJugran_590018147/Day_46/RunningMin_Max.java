import java.util.*;

public class RunningMin_Max {

    public static int maximizeSum(int[] arr) {
        int n = arr.length;

        if (n <= 1)
            return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find minimum and maximum
        for (int num : arr) {
            if (num < min)
                min = num;
            if (num > max)
                max = num;
        }

        // Create rearranged array
        int[] rearranged = new int[n];
        rearranged[0] = min;
        rearranged[1] = max;

        int index = 2;

        for (int num : arr) {
            if (num != min && num != max) {
                rearranged[index++] = num;
            }
        }

        // Handle duplicates of min and max
        boolean minUsed = false;
        boolean maxUsed = false;

        for (int num : arr) {
            if (num == min) {
                if (!minUsed) {
                    minUsed = true;
                } else {
                    rearranged[index++] = num;
                }
            } else if (num == max) {
                if (!maxUsed) {
                    maxUsed = true;
                } else {
                    rearranged[index++] = num;
                }
            }
        }

        // Calculate sum of (running max - running min)
        int runningMax = rearranged[0];
        int runningMin = rearranged[0];
        int sum = 0;

        for (int num : rearranged) {
            runningMax = Math.max(runningMax, num);
            runningMin = Math.min(runningMin, num);
            sum += (runningMax - runningMin);
        }

        System.out.println("Rearranged Array: " + Arrays.toString(rearranged));

        return sum;
    }

    public static void main(String[] args) {

        int[] arr = {7, 6, 5};

        int ans = maximizeSum(arr);

        System.out.println("Maximum Sum = " + ans);
    }
}