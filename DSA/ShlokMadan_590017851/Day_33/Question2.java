import java.util.Stack;
public class Question2 
{
    public String postfixToPrefix(String s) 
    {
        Stack<String> st=new Stack<>();
        for(char c:s.toCharArray())
            {
            if(Character.isLetterOrDigit(c))
                {
                st.push(String.valueOf(c));
            }
            else
                {
                String b=st.pop();
                String a=st.pop();
                st.push(c+a+b);
            }
        }
        return st.pop();
    }
    public static void main(String[] args) 
    {
        Solution obj=new Solution();
        System.out.println(obj.postfixToPrefix("AB+CD-*"));
        System.out.println(obj.postfixToPrefix("ABC/-AK/L-*"));
    }
}