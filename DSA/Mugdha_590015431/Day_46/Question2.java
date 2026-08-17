package DSA.Mugdha_590015431.Day_46;
import java.util.*;

public class Question2{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
for(int i=0;i<n;i++){
int x=sc.nextInt();
if(x<min) min=x;
if(x>max) max=x;
}
if(n==1) System.out.println(0);
else System.out.println((long)(n-1)*(max-min));
sc.close();
}
}