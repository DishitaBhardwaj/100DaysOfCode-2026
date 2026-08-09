import java.util.*;

public class Question1_Leetcode {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Question1_Leetcode(int k) {
        capacity = k;
        queue = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return queue[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String operationsLine = sc.nextLine();
        String argumentsLine = sc.nextLine();

        String[] operations = operationsLine
                .replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .split(",");

        List<String> arguments = new ArrayList<>();

        int depth = 0;
        StringBuilder current = new StringBuilder();

        for (int i = 0; i < argumentsLine.length(); i++) {

            char c = argumentsLine.charAt(i);

            if (c == '[') {
                depth++;
            }

            if (c == ']') {
                depth--;
            }

            if (c == ',' && depth == 1) {
                arguments.add(current.toString().trim());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }

        arguments.add(current.toString().trim());

        Question1_Leetcode circularQueue = null;

        System.out.print("[");

        for (int i = 0; i < operations.length; i++) {

            String operation = operations[i].trim();
            String argument = arguments.get(i);

            argument = argument
                    .replace("[", "")
                    .replace("]", "")
                    .trim();

            if (operation.equals("MyCircularQueue")) {

                int k = Integer.parseInt(argument);

                circularQueue = new Question1_Leetcode(k);

                System.out.print("null");

            } else if (operation.equals("enQueue")) {

                int value = Integer.parseInt(argument);

                System.out.print(circularQueue.enQueue(value));

            } else if (operation.equals("deQueue")) {

                System.out.print(circularQueue.deQueue());

            } else if (operation.equals("Front")) {

                System.out.print(circularQueue.Front());

            } else if (operation.equals("Rear")) {

                System.out.print(circularQueue.Rear());

            } else if (operation.equals("isEmpty")) {

                System.out.print(circularQueue.isEmpty());

            } else if (operation.equals("isFull")) {

                System.out.print(circularQueue.isFull());
            }

            if (i < operations.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        sc.close();
    }
}