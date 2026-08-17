package DSA.Mugdha_590015431.Day_45;
import java.util.Scanner;

public class Question2{
static long merge(int[] arr,int[] temp,int left,int mid,int right){
int i=left,j=mid,k=left;
long inv=0;
while(i<=mid-1&&j<=right){
if(arr[i]<=arr[j]) temp[k++]=arr[i++];
else{
temp[k++]=arr[j++];
inv+=mid-i;
}
}
while(i<=mid-1) temp[k++]=arr[i++];
while(j<=right) temp[k++]=arr[j++];
for(i=left;i<=right;i++) arr[i]=temp[i];
return inv;
}
static long mergeSort(int[] arr,int[] temp,int left,int right){
long inv=0;
if(left<right){
int mid=left+(right-left)/2;
inv+=mergeSort(arr,temp,left,mid);
inv+=mergeSort(arr,temp,mid+1,right);
inv+=merge(arr,temp,left,mid+1,right);
}
return inv;
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int[] arr=new int[n];
int[] temp=new int[n];
for(int i=0;i<n;i++) arr[i]=sc.nextInt();
System.out.println(mergeSort(arr,temp,0,n-1));
sc.close();
}
}