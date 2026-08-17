import java.util.*;

public class Question1_Leetcode {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int size = sc.nextInt();

        int arr[] = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < size - 1; i++) {

            for (int j = 0; j < size - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
        int diff = arr[1] - arr[0];

        boolean isAP = true;

        for (int i = 0; i < size - 1; i++) {

            if (arr[i + 1] - arr[i] != diff) {
                isAP = false;
                break;
            }

        }


        if (isAP) {
            System.out.println("True");
        } 
        else {
            System.out.println("False");
        }
    }
}