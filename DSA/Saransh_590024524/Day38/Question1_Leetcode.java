
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] arr = new int[2];
        for (int s : students) {
        arr[s]++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (arr[sandwiches[i]] == 0) {
                return sandwiches.length - i;
            }
            arr[sandwiches[i]]--;
        }
        return 0;
    }
}