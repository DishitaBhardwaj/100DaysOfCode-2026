package Day_20;
import Day_20.Node;
import java.util.*;
class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class d20question1_leetcode {
    
    public static class Solution {
    public Node removeElements(Node head, int val) {
        Node temp = new Node(0);
        temp.next = head;
        Node curr = temp;
        while (curr.next != null) 
        {
            if (curr.next.val == val)
                curr.next = curr.next.next; 
            else
                curr = curr.next; 
        }
        return temp.next;
    }
}
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first list: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements of first list (sorted):");
        Node list1 = null, tail1 = null;
        
        for (int i = 0; i < n1; i++) {
            Node node = new Node(sc.nextInt());
            if (list1 == null) {
                list1 = node;
                tail1 = node;
            } else {
                tail1.next = node;
                tail1 = node;
            }
        }
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();
        Solution sol = new Solution();
        Node rotated = sol.removeElements(list1,n);

while (rotated != null) {
    System.out.print(rotated.val + " ");
    rotated = rotated.next;
}
System.out.println();
sc.close();}}