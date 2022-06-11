// Problem Statement: Given two singly linked lists that are sorted in increasing order of node values, merge two sorted linked lists and return them as a sorted list. The list should be made by splicing together the nodes of the first two lists.

// Time Complexity: O(n)
// Auxiliary Space Complexity: O(1)

ListNode mergeTwoSortedList (ListNode firstList, ListNode secondList) {
	    // add your logic here
		ListNode temp;
		if(firstList.data > secondList.data){
			temp = firstList;
			firstList = secondList;
			secondList = temp;
		}
		ListNode head = firstList;
		ListNode prev = firstList;
		firstList = firstList.next;
		while(firstList!=null && secondList!=null){
			if(firstList.data > secondList.data){
				prev.next = secondList;
				temp = firstList;
				firstList = secondList;
				secondList = temp;
			}
			prev = firstList;
			firstList = firstList.next;
		}
		prev.next = secondList;
		return head;
	}