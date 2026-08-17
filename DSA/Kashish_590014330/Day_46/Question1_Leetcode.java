import java.util.*;
public class Question1_Leetcode{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array 1:");
        int n1=sc.nextInt();
        int nums1[]=new int[n1];
        System.out.println("Enter size of array 2:");
        int n2=sc.nextInt();
        int nums2[]=new int[n2];
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<n1;i++){
            nums1[i]=sc.nextInt();
        }
        for(int i=0;i<n2;i++){
            nums2[i]=sc.nextInt();
        }
        Arrays.sort(nums1);
        
        Arrays.sort(nums2);

        int i=0;
        int j=0;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if (nums1[i]>nums2[j]){
                j++;
            }
            else{
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
         ArrayList<Integer> unique = new ArrayList<>();

        for (int k = 0; k < result.size(); k++) {
            if (k == 0 || !result.get(k).equals(result.get(k - 1))) {
                unique.add(result.get(k));
            }
        }

        System.out.println("Intersection:");
        System.out.println(unique);

        sc.close();
        

                }

        }



    
