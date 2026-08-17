package DSA.Saransh_590024524.Day34;

import java.util.*;

class Solution {
    public int maxPeopleVisible(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                left[i] = 0;
            else
                left[i] = stack.peek() + 1;

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                right[i] = n - 1;
            else
                right[i] = stack.peek() - 1;

            stack.push(i);
        }

        int maxVisible = 0;
        for (int i = 0; i < n; i++) {
            int visible = right[i] - left[i] + 1;
            maxVisible = Math.max(maxVisible, visible);
        }

        return maxVisible;
    }
}
