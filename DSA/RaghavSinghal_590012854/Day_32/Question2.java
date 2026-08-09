import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        Stack<Integer> temp = new Stack<>();
        Stack<Integer> copy = new Stack<>();

        while (!st.isEmpty()) {
            temp.push(st.pop());
        }

        while (!temp.isEmpty()) {
            int x = temp.pop();
            st.push(x);
            copy.push(x);
        }

        System.out.println(copy);
    }
}