import java.util.Scanner;

class Question_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the valid parentheses string: ");
        String s = sc.nextLine();

        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (depth > 0)
                    result.append(ch);
                depth++;
            } else {
                depth--;
                if (depth > 0)
                    result.append(ch);
            }
        }

        System.out.println("Result: " + result.toString());
    }
}