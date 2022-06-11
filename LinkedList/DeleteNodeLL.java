// Delete given node in a Linked List : O(1) approach
// Problem Statement: Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list instead, you will be given access to the node to be deleted directly. It is guaranteed that the node to be deleted is not a tail node in the list.

public class Solution {
	public static void deleteNode(LinkedListNode<Integer> node) {
        if(node == null) return;
        node.data = node.next.data;
        node.next = node.next.next;
        return;
    }
}