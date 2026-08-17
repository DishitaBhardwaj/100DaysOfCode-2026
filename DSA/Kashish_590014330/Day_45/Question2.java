import java.util.*;

public class Question2{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array size");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();


        }
        int l=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if( arr[i] > arr[j]){
                    l++;
                }

            }
        }
        System.out.println(l);


    }
}