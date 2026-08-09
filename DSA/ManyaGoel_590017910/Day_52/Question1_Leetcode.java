public class Question1_Leetcode {
    public boolean areOccurrencesEqual(String s) {
        int[] freq = new int[26];
        for( int i=0 ; i<s.length() ; i++){
            freq[s.charAt(i) - 'a']++;
        }
        int common = freq[s.charAt(0)-'a'];
        for( int current: freq){
            if(current != 0 && current != common) return false;
        }
        return true;     
    }
}