package Day_32;

import java.util.*;

public class d32question2_technical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size of Array: ");
        int n = sc.nextInt();          
        int[] Arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print(": ");
            Arr[i] = sc.nextInt();     
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> result = new Stack<>();
        for(int c: Arr)
        {
            stack.push(c);
        }
        // System.out.println(stack); //available for checking
        for(int i=0;i<Arr.length;i++){
            middle.push(stack.pop());
        }
        // System.out.println(middle);//available for checking
        for(int i=0;i<Arr.length;i++){
            result.push(middle.pop());
        }
        System.out.println(result);
        sc.close();
    }
}
