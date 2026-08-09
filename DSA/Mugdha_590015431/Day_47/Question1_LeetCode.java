package DSA.Mugdha_590015431.Day_47;

import java.util.*;

public class Question1_LeetCode{
public static String[] findRelativeRanks(int[] score){
int n=score.length;
String[] ans=new String[n];
HashMap<Integer,Integer> map=new HashMap<>();
int[] sorted=score.clone();
Arrays.sort(sorted);
for(int i=0;i<n;i++) map.put(sorted[i],n-i);
for(int i=0;i<n;i++){
int rank=map.get(score[i]);
if(rank==1) ans[i]="Gold Medal";
else if(rank==2) ans[i]="Silver Medal";
else if(rank==3) ans[i]="Bronze Medal";
else ans[i]=String.valueOf(rank);
}
return ans;
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int[] score=new int[n];
for(int i=0;i<n;i++) score[i]=sc.nextInt();
String[] ans=findRelativeRanks(score);
System.out.print("[");
for(int i=0;i<n;i++){
System.out.print("\""+ans[i]+"\"");
if(i<n-1) System.out.print(",");
}
System.out.println("]");
sc.close();
}
}