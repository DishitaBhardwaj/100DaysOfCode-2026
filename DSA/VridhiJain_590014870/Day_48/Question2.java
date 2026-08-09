import java.util.*;
class Question2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = n * (n - 1) / 2;
        long[] b = new long[size];

        for (int i = 0; i < size; i++) 
        {
            b[i] = sc.nextLong();
        }

        Arrays.sort(b);
        long[] a = new long[n];
        int index = 0;
        for (int i = 0; i < n - 1; i++) 
        {
            a[i] = b[index];
            index += n - 1 - i;
        }
        a[n - 1] = a[n - 2];
        for (int i = 0; i < n; i++) 
        {
            System.out.print(a[i] + " ");
        }

        sc.close();
    }
}