import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Question2 {
    
    public static String officePrinterWars(String s) {
        int n = s.length();
        Queue<Integer> sales = new ArrayDeque<>();
        Queue<Integer> marketing = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'S') {
                sales.offer(i);
            } else {
                marketing.offer(i);
            }
        }
        
        while (!sales.isEmpty() && !marketing.isEmpty()) {
            int salesId = sales.poll();
            int marketingId = marketing.poll();
            
            if (salesId < marketingId) {
                sales.offer(salesId + n);
            } else {
                marketing.offer(marketingId + n);
            }
        }
        return sales.isEmpty() ? "Marketing" : "Sales";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the string with initial queue of jobs, the string should contain only characters 'S' and 'M': ");
        String s = sc.nextLine();
            
        String ans = officePrinterWars(s.toUpperCase());
        System.out.println("Last Remaining department: " + ans);
        sc.close();
    }
}