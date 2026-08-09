package Day_52;
import java.util.*;
class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> map=new HashMap<>(); 
        for (int i=0; i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int freq=-1;
    for (int count:map.values()){
        if (freq == -1){
            freq=count;
        }
        else if(count != freq){
            return false;
        }
    }
    return true;
}
}