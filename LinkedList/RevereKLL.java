// Reverse Linked List in groups of Size K
// In this article we will solve a very popular question Reverse Linked List in groups of Size K.

// Problem Statement: Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list. k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// Time Complexity: O(N)
// Reason: Nested iteration with O((N/k)*k) which makes it equal to O(N).
// Space Complexity: O(1)

static int lengthOfLinkedList(Node head) {
    int length = 0;
    while(head != null) {
        ++length;
        head = head.next;
    }
    return length;
}
//utility function to reverse k nodes in the list
static Node reverseKNodes(Node head,int k) {
    if(head == null||head.next == null) return head;
    
    int length = lengthOfLinkedList(head);
    
    Node dummyHead = new Node(0);
    dummyHead.next = head;
    
    Node pre = dummyHead;
    Node cur;
    Node nex;
    
    while(length >= k) {
        cur = pre.next;
        nex = cur.next;
        for(int i=1;i<k;i++) {
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
            nex = cur.next;
        }
        pre = cur;
        length -= k;
    }
    return dummyHead.next;
}

