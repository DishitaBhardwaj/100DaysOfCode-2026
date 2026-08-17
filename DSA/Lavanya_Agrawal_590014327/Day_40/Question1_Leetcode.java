import java.util.*;

class Question1_Leetcode {

    private Deque<Integer> left;
    private Deque<Integer> right;

    public Question1_Leetcode() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    private void balance() {
        while (left.size() > right.size() + 1) {
            right.addFirst(left.removeLast());
        }

        while (left.size() < right.size()) {
            left.addLast(right.removeFirst());
        }
    }

    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() > right.size()) {
            right.addFirst(left.removeLast());
        }

        left.addLast(val);
        balance();
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    public int popFront() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }

        int result;

        if (!left.isEmpty()) {
            result = left.removeFirst();
        } else {
            result = right.removeFirst();
        }

        balance();

        return result;
    }

    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }

        int result = left.removeLast();

        balance();

        return result;
    }

    public int popBack() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }

        int result;

        if (!right.isEmpty()) {
            result = right.removeLast();
        } else {
            result = left.removeLast();
        }

        balance();

        return result;
    }


    // MAIN METHOD
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read first line
        String operations = sc.nextLine();

        // Read second line
        String values = sc.nextLine();

        // Remove [ and ]
        operations = operations.substring(1, operations.length() - 1);
        values = values.substring(1, values.length() - 1);

        // Split operations
        String[] ops = operations.split(", ");

        // Split values
        String[] vals = values.split("\\], \\[");

        Question1_Leetcode queue = new Question1_Leetcode();

        List<String> output = new ArrayList<>();

        for (int i = 0; i < ops.length; i++) {

            String operation = ops[i].replace("\"", "").trim();

            if (operation.equals("FrontMiddleBackQueue")) {

                output.add("null");

            } 
            else if (operation.equals("pushFront")) {

                int value = Integer.parseInt(
                    vals[i].replace("[", "")
                          .replace("]", "")
                );

                queue.pushFront(value);
                output.add("null");

            } 
            else if (operation.equals("pushMiddle")) {

                int value = Integer.parseInt(
                    vals[i].replace("[", "")
                          .replace("]", "")
                );

                queue.pushMiddle(value);
                output.add("null");

            } 
            else if (operation.equals("pushBack")) {

                int value = Integer.parseInt(
                    vals[i].replace("[", "")
                          .replace("]", "")
                );

                queue.pushBack(value);
                output.add("null");

            } 
            else if (operation.equals("popFront")) {

                output.add(String.valueOf(queue.popFront()));

            } 
            else if (operation.equals("popMiddle")) {

                output.add(String.valueOf(queue.popMiddle()));

            } 
            else if (operation.equals("popBack")) {

                output.add(String.valueOf(queue.popBack()));
            }
        }

        System.out.println(output);

        sc.close();
    }
}