// Rotate a Linked List
// In this article we will solve the problem: “Rotate a Linked List”

// Problem Statement: Given the head of a linked list, rotate the list to the right by k places.

static Node rotateRight(Node head,int k) {
    if(head == null||head.next == null||k == 0) return head;
    //calculating length
    Node temp = head;
    int length = 1;
    while(temp.next != null) {
        ++length;
        temp = temp.next;
    }
    //link last node to first node
    temp.next = head;
    k = k%length; //when k is more than length of list
    int end = length-k; //to get end of the list
    while(end--!=0) temp = temp.next;
    //breaking last node link and pointing to NULL
    head = temp.next;
    temp.next = null;
        
    return head;
}