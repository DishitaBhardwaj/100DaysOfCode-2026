import java.util.Stack;
public class Question1 
{
    public static int minLength(String s)
    {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
            {
            char ch=s.charAt(i);
            if(!st.isEmpty() && ((st.peek()=='A' && ch=='B') || (st.peek()=='C' && ch=='D')))
                st.pop();
            else
                st.push(ch);
        }
        return st.size();
    }
    public static void main(String[] args)
    {
        String s="ABFCACDB";
        System.out.println(minLength(s));
    }
}