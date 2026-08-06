class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(m.containsKey(ch)){
                m.put(ch,m.get(ch)+1);
            } else{
                m.put(ch,1);
            }
        }

        Set<Integer> st=new HashSet<Integer>(m.values());
        if(st.size()==1){
            return true;
        } else{
            return false;
        }
    }
}