class Solution {
    public int maxFrequencyElements(int[] nums) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        for( int num : nums ){

            freq.put( num, freq.getOrDefault(num,0) + 1);
        }

        int max_freq = 0;
        for( int count : freq.values()) {

            max_freq = Math.max( max_freq, count);
        }

        int ans = 0;
        for( int count : freq.values() ) {
            if( count == max_freq ){
                ans += count;
            }
        }
        return ans;
    }
}