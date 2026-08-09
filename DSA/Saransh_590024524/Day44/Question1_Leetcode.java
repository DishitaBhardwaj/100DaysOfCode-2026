package DSA.Saransh_590024524.Day44;

public class Question1_Leetcode {
    public boolean canMakeArithmeticProgression(int[] arr) {
        // Arrays.sort(arr);
        int i,j,temp;
        for(i=0 ; i<arr.length-1 ; i++)
        {
          for (j=0;j<arr.length-i-1;j++)
          {
            if(arr[j] > arr[j+1])
            {
              temp = arr[j];
              arr[j] = arr[j+1];
              arr[j+1]=temp;
            }
          }
        }
        int d = arr[1] - arr[0];
        for(i =2 ; i<arr.length ; i++)
        {
            if(arr[i] - arr[i-1] != d)
                return false;
        }
        return true;
    }
}
