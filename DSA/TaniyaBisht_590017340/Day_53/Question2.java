
import java.util.*;
class SS{
    public static List<Integer> findAnagrams(String log, String pattern){
        List<Integer> ans = new ArrayList<>();
        if(log.length() < pattern.length())
            return ans;
        int[] pFreq = new int[26];
        int[] wFreq = new int[26];
        for(int i = 0; i < pattern.length(); i++){
            pFreq[pattern.charAt(i) - 'a']++;
        }
        int st = 0;
        for(int i = 0; i < log.length(); i++){
            wFreq[log.charAt(i) - 'a']++;
            if(i - st + 1 == pattern.length()){
                if(Arrays.equals(pFreq, wFreq)){
                    ans.add(st);
                }
                wFreq[log.charAt(st) - 'a']--;
                st++;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        String log = "cbaebabacd";
        String pattern = "abc";
        System.out.println(findAnagrams(log, pattern));
    }
}