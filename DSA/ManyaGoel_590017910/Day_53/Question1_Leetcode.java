public class Question1_Leetcode {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for ( int i = 0 ; i < s.length()-2 ; i++ ){
            char first = s.charAt(i);
            char second = s.charAt(i+1);
            char third = s.charAt(i+2);
        
        if ( first != second && second != third && third != first){
            count++;
        }
      }
        return count;
    }
}