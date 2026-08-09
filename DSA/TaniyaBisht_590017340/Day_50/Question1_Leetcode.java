
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {
            if(a[0]!=b[0]){
                return a[0] - b[0];
            }
            else{
                return a[1] - b[1];
            }
        });
        for(int i=0; i<nums.length; i++){
            q.add(new int[]{nums[i], i});
        }
        for(int i=1; i<=k; i++){
            int top[] = q.poll();
            int idx = top[1];
            nums[idx] = top[0] * multiplier;
            q.add(new int[]{nums[idx], idx});
        }
        return nums;
    }
}