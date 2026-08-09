import java.util.Scanner;
public class Question2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) 
        {
            nums[i] = sc.nextInt();
        }

        int favIdx = sc.nextInt();
        int k = sc.nextInt();
        int favVal = nums[favIdx - 1];
        int greater = 0;
        int equal = 0;

        for (int i = 0; i < n; i++) 
        {
            if (nums[i] > favVal) 
            {
                greater++;
            } 
            else if (nums[i] == favVal) 
            {
                equal++;
            }
        }

        if (k <= greater) 
        {
            System.out.println("NO");
        } 
        else if (k > greater + equal - 1) 
        {
            System.out.println("YES");
        } 
        else 
        {
            System.out.println("MAYBE");
        }

        sc.close();
    }
}