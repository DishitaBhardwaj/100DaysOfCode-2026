String postfixToPrefix(String s) {
    Stack<String> st = new Stack<>();

    for (char c : s.toCharArray()) {
        if (Character.isLetter(c)) {
            st.push(c + "");
        } else {
            String a = st.pop();
            String b = st.pop();
            st.push(c + b + a);
        }
    }

    return st.peek();
}