public class FavouriteNo {

    public static String RemoveFavouriteNo( int[] arr, int idx, int k ) {
    
        int fav_no = arr[idx - 1];

        int greater = 0 , count_favno = 0;

        for( int i = 0 ; i < arr.length ; i++ ){

            if( arr[i] == fav_no ){
                count_favno++;
            }
            else if( arr[i] > fav_no ){
                greater++;
            }
            else{
                continue;
            }
        }

        if( greater >= k ){
            return "NO";
        }
        else if( greater + count_favno <= k ){
            return "YES";
        }
        else{
            return "MAYBE";
        }


        
    }

    public static void main( String[] args){

        int[] arr = {4, 3, 3, 2, 3};

        int fav_index = 2;

        int k = 2;

        String ans = RemoveFavouriteNo( arr, fav_index , k );
        System.out.println(ans);

    }
    
}
