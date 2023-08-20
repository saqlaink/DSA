/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // if(head == null || head.next == null) return true;
        // ListNode slow = head;
        // ListNode fast = head;
        // while(fast.next != null && fast.next.next != null){
        //     fast = fast.next.next;
        //     slow = slow.next;
        // }
        // slow.next = reverse(slow.next); //adding the next pointer to last element
        // slow = slow.next;
        // while(slow!= null){
        //     if(head.val != slow.val) return false;
        //     slow = slow.next;
        //     head = head.next;
        // }
        // return true;
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = reverse(slow.next);
        slow = slow.next;
        while(slow!=null){
            if(head.val != slow.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        while(head!= null){
            next = head.next;
            head.next = prev; 
            prev = head;
            head = next;
        }
        return prev;
    }
}