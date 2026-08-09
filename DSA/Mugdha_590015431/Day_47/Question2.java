package DSA.Mugdha_590015431.Day_47;

import java.util.*;

public class Question2{
public static int kthSmallest(int[] A,int[] B,int k){
if(A.length>B.length) return kthSmallest(B,A,k);
int n=A.length,m=B.length;
int low=Math.max(0,k-m),high=Math.min(k,n);
while(low<=high){
int cut1=(low+high)/2;
int cut2=k-cut1;
int l1=cut1==0?Integer.MIN_VALUE:A[cut1-1];
int l2=cut2==0?Integer.MIN_VALUE:B[cut2-1];
int r1=cut1==n?Integer.MAX_VALUE:A[cut1];
int r2=cut2==m?Integer.MAX_VALUE:B[cut2];
if(l1<=r2&&l2<=r1) return Math.max(l1,l2);
if(l1>r2) high=cut1-1;
else low=cut1+1;
}
return -1;
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int[] A=new int[n];
for(int i=0;i<n;i++) A[i]=sc.nextInt();
int m=sc.nextInt();
int[] B=new int[m];
for(int i=0;i<m;i++) B[i]=sc.nextInt();
int k=sc.nextInt();
System.out.println(kthSmallest(A,B,k));
sc.close();
}
}