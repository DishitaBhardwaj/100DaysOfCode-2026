import java.util.Scanner;

class Question_1 {

    int[] queue;
    int front;
    int rear;
    int size;
    int capacity;

    public Question_1(int k) {
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

        System.out.print("Enter size of circular queue: ");
        int k = sc.nextInt();

        Question_1 q = new Question_1(k);

        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\n1. EnQueue");
            System.out.println("2. DeQueue");
            System.out.println("3. Front");
            System.out.println("4. Rear");
            System.out.println("5. Is Empty");
            System.out.println("6. Is Full");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = sc.nextInt();

                    System.out.println("EnQueue: " + q.enQueue(value));
                    break;

                case 2:
                    System.out.println("DeQueue: " + q.deQueue());
                    break;

                case 3:
                    System.out.println("Front element: " + q.Front());
                    break;

                case 4:
                    System.out.println("Rear element: " + q.Rear());
                    break;

                case 5:
                    System.out.println("Is queue empty: " + q.isEmpty());
                    break;

                case 6:
                    System.out.println("Is queue full: " + q.isFull());
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}