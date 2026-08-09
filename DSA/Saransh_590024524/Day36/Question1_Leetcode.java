package DSA.Saransh_590024524.Day36;

import java.util.*;

public class Question1_Leetcode {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        int n = q.size();
        for (int i = 0; i < n - 1; i++) {
            q.add(q.remove());
        }
        q.add(30);
        n = q.size();
        for (int i = 0; i < n - 1; i++) {
            q.add(q.remove());
        }
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
    }
}