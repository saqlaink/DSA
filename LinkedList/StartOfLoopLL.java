// Starting point of loop in a Linked List
// Problem Statement: Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

// Time Complexity: O(N)
// Reason: We can take overall iterations club it to O(N)
// Space Complexity: O(1)

static Node detectCycle(Node head) {
    if(head == null||head.next == null) return null;
        
    Node fast = head;
    Node slow = head;
    Node entry = head;
        
    while(fast.next != null&&fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
            
        if(slow == fast) {
            while(slow != entry) {
                slow = slow.next;
                entry = entry.next;
            }
            return slow;
        }
    }
    return null;
}

