// Check if given Linked List is Plaindrome
// Problem Statement: Given the head of a singly linked list, return true if it is a palindrome.

// Time Complexity: O(N/2)+O(N/2)+O(N/2)
// Reason: O(N/2) for finding the middle element, reversing the list from the middle element, and traversing again to find palindrome respectively.
// Space Complexity: O(1)

static Node reverse(Node ptr) {
    Node pre=null;
    Node nex=null;
    while(ptr!=null) {
        nex = ptr.next;
        ptr.next = pre;
        pre=ptr;
        ptr=nex;
    }
    return pre;
}

static boolean isPalindrome(Node head){
    if(head==null||head.next==null) return true;
        
    Node slow = head;
    Node fast = head;
        
    while(fast.next!=null&&fast.next.next!=null) {
        slow = slow.next;
        fast = fast.next.next;
    }
        
    slow.next = reverse(slow.next);
    slow = slow.next;
    Node dummy = head;
        
    while(slow!=null) {
        if(dummy.num != slow.num) return false;
        dummy = dummy.next;
        slow = slow.next;
    }
    return true;
}
