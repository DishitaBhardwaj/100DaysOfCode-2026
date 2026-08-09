import java.util.*;
public class Question2 {
    public static String prefixConversion(String str){
        Stack <String> stack = new Stack<>();
        for( char c : str.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            }else{
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                stack.push( c + operand1 + operand2);
            }
        }
    return stack.peek();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Postfix Expression: ");
        String str = sc.nextLine();
        System.out.println("Postfix Expression: \"" + str + "\"");
        System.out.println("Prefix Expression: \"" + prefixConversion(str) + "\"");
        sc.close();
    }
}