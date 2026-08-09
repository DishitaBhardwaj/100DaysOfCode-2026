class Solution {
    public String[] findRelativeRanks(int[] score) {
       int cpy[]=Arrays.copyOf(score,score.length);
       Arrays.sort(cpy);
       HashMap<Integer,String> h=new HashMap<>();
       posnhelper(cpy,h);
       String res[]=new String[score.length];
       int idx=0;
       for(int n:score){
        res[idx++]=h.get(n);
       }
       return res;
    }

    void posnhelper(int[] a,HashMap<Integer,String> h){
        int n=a.length;
        int pos=4;
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                h.put(a[i],"Gold Medal");
            }
            else if(i==n-2){
                h.put(a[i],"Silver Medal");
            }
            else if(i==n-3){
                h.put(a[i],"Bronze Medal");
            }
            else{
                h.put(a[i],Integer.toString(pos));
                pos++;
            }

        }
    }
}