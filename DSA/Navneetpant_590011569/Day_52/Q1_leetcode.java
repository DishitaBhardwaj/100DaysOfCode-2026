class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap <Character, Integer> hm = new HashMap <> ();
        for (int i = 0 ; i < s.length() ; i++ ) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i),0) +1);
        }
        int val = hm.get(s.charAt(0));
        for (Map.Entry <Character , Integer> entry : hm.entrySet()) {
            if (entry.getValue()!=val) {
                return false;
            }
        }
        return true; 


        
    }
}