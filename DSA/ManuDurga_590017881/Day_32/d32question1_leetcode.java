package Day_32;

import java.util.*;
public class d32question1_leetcode {
    
    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.empty()) stack.push(c);
            else if(stack.peek() == 'A'&& c=='B'||stack.peek() == 'C'&& c=='D') stack.pop();
            else stack.push(c);
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        System.out.print(minLength(sc.nextLine()));
        sc.close();
    }
}
