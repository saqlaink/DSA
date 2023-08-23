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
    ListNode mergeTwoSortedLists(ListNode A, ListNode B){
        if(A == null) return B;
        if(B == null) return A;
        ListNode output = null;
        if(A.val < B.val){
            output = A;
            A = A.next;
        }else{
            output = B;
            B = B.next;
        }
        ListNode curr = output;
        while(A!=null && B!=null){
            if(A.val > B.val){
                curr.next = B;
                B = B.next;
            }else{
                curr.next = A;
                A = A.next;
            }
            curr = curr.next;
        }
        if(A != null) curr.next = A;
        if(B != null) curr.next = B;
        return output;
    }
    public ListNode mergeKLists(ListNode[] lists){
        int k = lists.length;
        if(k == 0) return null;
        int interval = 1;
        while(interval < k){
            int i = 0;
            while(i + interval < k){
                lists[i] = mergeTwoSortedLists(lists[i], lists[i+interval]);
                i = i + interval * 2;
            }
            interval *= 2;
        }
        return lists[0];
    }
}