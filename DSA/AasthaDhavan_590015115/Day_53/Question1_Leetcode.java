class Solution {
    public int countGoodSubstrings(String s) {
        int st=0;
        int c=0;
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            int r=i-st+1;
            if(r==3){
                if(isgood(arr)){
                    c++;
                }
                arr[s.charAt(st++)-'a']--;
            }
        }
        return c;
       
    }
     private boolean isgood(int[] arr){
            for(int j=0;j<26;j++){
                if(arr[j]>1){
                    return false;
                }
            }
            return true;
        }
}