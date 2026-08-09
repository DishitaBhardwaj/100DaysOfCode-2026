
import java.util.*;
class OP{
    public static void main(String[] args){
        String jobs = "SMMMS";
        Queue<Integer> sales = new LinkedList<>();
        Queue<Integer> marketing = new LinkedList<>();
        for (int i = 0; i < jobs.length(); i++) {
            if(jobs.charAt(i) == 'S') {
                sales.add(i);
            } 
            else{
                marketing.add(i);
            }
        }
        int n = jobs.length();
        while(!sales.isEmpty() && !marketing.isEmpty()) {
            int s = sales.remove();
            int m = marketing.remove();
            if(s < m) {
                sales.add(s + n);
            } 
            else{
                marketing.add(m + n);
            }
        }
        if(sales.isEmpty()) {
            System.out.println("Marketing");
        }
         else{
            System.out.println("Sales");
        }
    }
}