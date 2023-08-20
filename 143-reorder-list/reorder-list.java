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
    public void reorderList(ListNode head) {
        // if(head == null || head.next == null) return;
        // //find middle
        // ListNode fast = head,slow = head;
        // while(fast.next != null && fast.next.next != null){
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        // //slow pointing at mid
        // ListNode headSecondHalf = reverse(slow);
        // ListNode headFirstHalf = head;
        // while(headFirstHalf != null && headSecondHalf != null){
        //     ListNode temp = headFirstHalf.next;
        //     headFirstHalf.next = headSecondHalf;
        //     headFirstHalf = temp;
        //     temp = headSecondHalf.next;
        //     headSecondHalf.next = headFirstHalf;
        //     headSecondHalf = temp;
        // }
        // if(headFirstHalf != null) headFirstHalf = null;
        if(head == null || head.next == null) return;
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headSecondHalf = reverse(slow);
        ListNode headFirstHalf = head;
        while(headFirstHalf != null && headSecondHalf != null){
            ListNode temp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = temp;
            temp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = temp;
        }
        if(headFirstHalf != null) headFirstHalf = null;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}