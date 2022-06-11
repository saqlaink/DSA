// Remove N-th node from the end of a Linked List
// Problem Statement: Given a linked list, and a number N. Find the Nth node from the end of this linkedlist, and delete it. Return the head of the new modified linked list.

public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K) {
        LinkedListNode<Integer> start = new LinkedListNode(-1);
        start.next = head;
        LinkedListNode<Integer> fast = start;
        LinkedListNode<Integer> slow = start;
        if(head == null || K==0) return head;
        for(int i=1;i<=K;i++){
            fast = fast.next;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }