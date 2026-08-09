import java.util.*;
class convert
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter postfix expression:");
        String s=sc.nextLine();

        Stack<String> st = new Stack<>();

        for(int i=0 ; i<s.length();i++)
        {
            char ch=s.charAt(i);

            if(character.isLetter(ch))
            {
                st.push(ch + "");
            }
            else
            {
                String right = st.pop();
                String left = st.pop();

                String temp=ch + left + right;

                st.push(temp);
            }
        }
        System.out.println("Prefix Expression:" + st.pop());
    }
}