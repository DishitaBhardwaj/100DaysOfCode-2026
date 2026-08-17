package DSA.Mugdha_590015431.Day_46;
import java.util.*;

public class Question1_LeetCode{
public static int[] intersection(int[] nums1,int[] nums2){
HashSet<Integer> set1=new HashSet<>();
HashSet<Integer> result=new HashSet<>();
for(int num:nums1) set1.add(num);
for(int num:nums2){
if(set1.contains(num)) result.add(num);
}
int[] ans=new int[result.size()];
int i=0;
for(int num:result) ans[i++]=num;
return ans;
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n1=sc.nextInt();
int[] nums1=new int[n1];
for(int i=0;i<n1;i++) nums1[i]=sc.nextInt();
int n2=sc.nextInt();
int[] nums2=new int[n2];
for(int i=0;i<n2;i++) nums2[i]=sc.nextInt();
int[] ans=intersection(nums1,nums2);
System.out.print("[");
for(int i=0;i<ans.length;i++){
System.out.print(ans[i]);
if(i<ans.length-1) System.out.print(",");
}
System.out.println("]");
sc.close();
}
}