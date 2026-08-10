class Solution {
    public int countGoodSubstrings(String s) {

        int count = 0;
        //since window size is fixed and small(3) we can use loop
        for( int i = 0 ; i <= s.length() - 3 ; i++ ){

            char first = s.charAt(i);
            char second = s.charAt(i + 1);
            char third = s.charAt(i + 2);

            if( first != second && second != third && third != first ){
                count++;
            }
        }
        return count;
    }
}