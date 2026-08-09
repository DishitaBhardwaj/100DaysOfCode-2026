package DSA.Mugdha_590015431.Day_48;
import java.util.*;

public class Question1_LeetCode{
public static int[][] sortTheStudents(int[][] score,int k){
Arrays.sort(score,(a,b)->b[k]-a[k]);
return score;
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int m=sc.nextInt();
int n=sc.nextInt();
int[][] score=new int[m][n];
for(int i=0;i<m;i++){
for(int j=0;j<n;j++){
score[i][j]=sc.nextInt();
}
}
int k=sc.nextInt();
int[][] ans=sortTheStudents(score,k);
System.out.print("[");
for(int i=0;i<m;i++){
System.out.print("[");
for(int j=0;j<n;j++){
System.out.print(ans[i][j]);
if(j<n-1) System.out.print(",");
}
System.out.print("]");
if(i<m-1) System.out.print(",");
}
System.out.println("]");
sc.close();
}
}