
class Question1_leetcode {

    // Function to check if the array can be rearranged into an arithmetic progression
    

          public boolean canMakeArithmeticProgression(int[] arr) {

            // Step 1: Sort the array in ascending order.
            // If the array CAN form an arithmetic progression,
            // sorting it will automatically arrange it into that exact progression.
            Arrays.sort(arr);

            // Step 2: Calculate the common difference using the first two elements.
            // This is the difference every consecutive pair must match.
            int commonDifference = arr[1] - arr[0];

            // Step 3: Walk through the sorted array and check that every
            // consecutive pair has the SAME difference as commonDifference.
            for (int i = 1; i < arr.length - 1; i++) {
                int currentDifference = arr[i + 1] - arr[i];

                // If any difference doesn't match, it's not an arithmetic progression.
                if (currentDifference != commonDifference) {
                    return false;
                }
            }

            // If we made it through the whole array without mismatches,
            // it's a valid arithmetic progression.
            return true;
        }
    }

    // Main method to test the function
    public static void main(String[] args) {

        // Example 1: can be rearranged into [1, 2, 3, 4, 5] -> valid AP
        int[] arr1 = {3, 5, 1, 4, 2};
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Can make arithmetic progression? " + canMakeArithmeticProgression(arr1));

        System.out.println();

        // Example 2: cannot be rearranged into any valid AP
        int[] arr2 = {1, 2, 4};
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Can make arithmetic progression? " + canMakeArithmeticProgression(arr2));
    }
}
