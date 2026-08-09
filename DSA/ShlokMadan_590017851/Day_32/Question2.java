import java.util.Stack;
public class Question2 
{
    public static void copy(Stack<Integer> st,Stack<Integer> temp)
    {
        if(st.isEmpty())
            return;
        int x=st.pop();
        copy(st,temp);
        temp.push(x);
        st.push(x);
    }
    public static Stack<Integer> copyStack(Stack<Integer> st)
    {
        Stack<Integer> temp=new Stack<>();
        copy(st,temp);
        return temp;
    }

    public static void main(String[] args)
    {
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        Stack<Integer> ans=copyStack(st);
        System.out.println(ans);
    }
}