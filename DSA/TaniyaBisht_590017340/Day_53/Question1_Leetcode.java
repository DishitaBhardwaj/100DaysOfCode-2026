
class Solution {
    public int countGoodSubstrings(String s) {
        int st=0;
        int count=0;
        int[] arr= new int[26];
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i) -'a']++;
            int range = i - st + 1;
            if(range==3){
                if(isGoodString(arr)){
                    count++;
                }
                arr[s.charAt(st++) -'a']--;
            }
        }
        return count;
    }
    private boolean isGoodString(int[] arr){
        for(int j=0; j<26; j++){
            if(arr[j] > 1){
                return false;
            }
        }
        return true;
    }
}