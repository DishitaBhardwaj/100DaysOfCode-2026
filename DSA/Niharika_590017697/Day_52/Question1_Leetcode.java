class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) 
        {
            freq[ch - 'a']++;
        }

        int count = 0;
        for (int f : freq) 
        {
            if (f != 0) 
            {
                if (count == 0) 
                {
                    count = f;
                } 
                else if (count != f) 
                {
                    return false;
                }
            }
        }

        return true;
    }
}