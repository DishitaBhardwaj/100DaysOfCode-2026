import java.util.*;

public class Question2 {
    public String predictDepartment(String jobs) {
        int n = jobs.length();
        
        Queue<Integer> sQueue = new LinkedList<>();
        Queue<Integer> mQueue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (jobs.charAt(i) == 'S') {
                sQueue.offer(i);
            } else {
                mQueue.offer(i);
            }
        }

        while (!sQueue.isEmpty() && !mQueue.isEmpty()) {
            int sIndex = sQueue.poll();
            int mIndex = mQueue.poll();
            
            if (sIndex < mIndex) {
                sQueue.offer(sIndex + n);
            } else {
                mQueue.offer(mIndex + n);
            }
        }
        
        return sQueue.isEmpty() ? "Marketing" : "Sales";
    }

    public static void main(String[] args) {
        Question2 obj = new Question2();
        
        System.out.println(obj.predictDepartment("SM"));   
    }
}