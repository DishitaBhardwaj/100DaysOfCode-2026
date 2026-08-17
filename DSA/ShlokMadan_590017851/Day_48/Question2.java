import java.util.Arrays;

public class Question2 {

    public static int[] constructArray(int n,int[] b) {

        Arrays.sort(b);

        int[] a=new int[n];

        int index=0;

        for(int i=0;i<n-1;i++) {
            a[i]=b[index];
            index+=n-i-1;
        }

        a[n-1]=1000000000;

        return a;
    }

    public static void main(String[] args) {

        int n=3;
        int[] b={4,2,2};

        System.out.println(Arrays.toString(constructArray(n,b)));
    }
}