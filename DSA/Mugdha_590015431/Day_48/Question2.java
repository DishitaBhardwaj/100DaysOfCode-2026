package DSA.Mugdha_590015431.Day_48;
import java.util.*;

public class Question2{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int m=n*(n-1)/2;
int[] b=new int[m];
for(int i=0;i<m;i++) b[i]=sc.nextInt();
Arrays.sort(b);
int[] a=new int[n];
int pos=0;
for(int i=0;i<n-1;i++){
a[i]=b[pos];
pos+=n-1-i;
}
a[n-1]=1000000000;
System.out.print("[");
for(int i=0;i<n;i++){
System.out.print(a[i]);
if(i<n-1) System.out.print(", ");
}
System.out.println("]");
sc.close();
}
}