import java.util.Random;
import java.util.*;
import java.io.*;

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q4 {
    private static final Random rand = new Random();

    // Shuffle list
    public static ListNode shuffle(ListNode head) {
        if (head == null || head.next == null) return head; 

        // Split list
        ListNode mid = getMiddle(head);
        ListNode secondHalf = mid.next;
        mid.next = null; 

        // Recursively shuffle both halves
        ListNode left = shuffle(head);
        ListNode right = shuffle(secondHalf);

        // Merge 
        return mergeRandom(left, right);
    }
 
    private static ListNode getMiddle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

 
    private static ListNode mergeRandom(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        
        if (rand.nextBoolean()) { 
            a.next = mergeRandom(a.next, b);
            return a;
        } else { 
            b.next = mergeRandom(a, b.next);
            return b;
        }
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // Shuffle 
        head = shuffle(head);

        System.out.println("Shuffled List:");
        printList(head);
    }
}


            