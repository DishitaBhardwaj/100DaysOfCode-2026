public class Q2{
    public static void main(String[] args){
        String s="ABC/-AK/L-*";
        String[] stack = new String[100];
        int top = -1;

        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isLetter(c)){
                stack[++top]=String.valueof(c);
            }else{
                String combined = c +stack[top-1]+stack[top];
                top--;
                stack[top]=combined;
            }
        }
        System.out.println(stack[top]);
    }
}