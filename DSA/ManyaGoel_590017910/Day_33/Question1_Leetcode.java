public class Question1_Leetcode{
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int j=0;
        for( char c : s.toCharArray()){
            if( c=='('){
                if (j > 0){
                    result.append(c);
                }
                j++;
            }else{
                j--;
                if (j > 0){
                    result.append(c);
                }
            }
        }
    return result.toString() ;
    }
}