import java.util.Stack;

public class Problem2 {
    public Stack<Integer> copyStack(Stack<Integer> st) {
        Stack<Integer> copied = new Stack<>();
        copyRecursive(st, copied);
        return copied;
    }

    private void copyRecursive(Stack<Integer> st, Stack<Integer> copied) {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();
        copyRecursive(st, copied);
        copied.push(top);
    }
}