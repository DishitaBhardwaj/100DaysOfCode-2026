import java.util.Arrays;
import java.util.HashMap;
public class Question1 
{
    public static String[] findRelativeRanks(int[] score) 
    {
        int[] temp=score.clone();
        Arrays.sort(temp);
        HashMap<Integer,String> map=new HashMap<>();
        int rank=1;
        for(int i=temp.length-1;i>=0;i--) 
            {
            if(rank==1) 
                {
                map.put(temp[i],"Gold Medal");
            }
            else if(rank==2) 
                {
                map.put(temp[i],"Silver Medal");
            }
            else if(rank==3) 
                {
                map.put(temp[i],"Bronze Medal");
            }
            else 
                {
                map.put(temp[i],String.valueOf(rank));
            }
            rank++;
        }
        String[] ans=new String[score.length];
        for(int i=0;i<score.length;i++) 
            {
            ans[i]=map.get(score[i]);
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        int[] score={5,4,3,2,1};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }
}