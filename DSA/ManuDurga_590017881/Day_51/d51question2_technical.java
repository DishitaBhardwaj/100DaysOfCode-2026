package Day_51;

import java.util.*;

public class d51question2_technical {
    public static int firstInvalidRecord(String[][] deliveries) {
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < deliveries.length; i++) {
            String vendor = deliveries[i][0];
            String lot = deliveries[i][1];
            String cert = deliveries[i][2];

            String key = vendor + "#" + lot;

            if (!map.containsKey(key)) {
                map.put(key, cert);
            } else {
                if (!map.get(key).equals(cert)) {
                    return i;
                }
            }
        }

        return -1;
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n1 = sc.nextInt();
        System.out.print("Enter Size of Array: ");
        int n2 = sc.nextInt();
        sc.nextLine();
        String[][]Arr1 = new String[n1][n2];
        for(int i=0;i<n1;i++){
            for (int j = 0; j < n2; j++) {
            System.out.print(": ");
            Arr1[i][j] = sc.nextLine();}}

        System.out.println(firstInvalidRecord(Arr1));
        sc.close();}}
