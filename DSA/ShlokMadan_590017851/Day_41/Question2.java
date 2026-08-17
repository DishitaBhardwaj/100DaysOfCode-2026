import java.util.ArrayDeque;
import java.util.Queue;

public class Question2{
    public static String officePrinterWars(String jobs){
        int n=jobs.length();
        Queue<Integer> sales=new ArrayDeque<>();
        Queue<Integer> marketing=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            if(jobs.charAt(i)=='S') sales.offer(i);
            else marketing.offer(i);
        }

        while(!sales.isEmpty() && !marketing.isEmpty()){
            int s=sales.poll();
            int m=marketing.poll();
            if(s<m) sales.offer(s+n);
            else marketing.offer(m+n);
        }

        return sales.isEmpty()? "Marketing" : "Sales";
    }

    public static void main(String[] args){
        System.out.println(officePrinterWars("SM"));  
        System.out.println(officePrinterWars("SMM"));
        System.out.println(officePrinterWars("MSS")); 
    }
}