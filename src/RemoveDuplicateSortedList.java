/**
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class RemoveDuplicateSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if ( head == null) return head;
    	ListNode n1 = head;
        ListNode n2;
        while(n1 != null && n1.next != null) {
        	n2 = n1.next;
        	if (n1.val == n2.val) {
        		n1.next = n2.next;
        	} else {
        		n1 = n2;
        	}
        }
        return head;
    }
    
    public static void main(String args[]) {
    	ListNode h1 = new ListNode(1);
    	ListNode h2 = new ListNode(1);
    	ListNode h3 = new ListNode(2);
    	ListNode h4 = new ListNode(3);
    	ListNode h5 = new ListNode(4);
    	ListNode h6 = new ListNode(4);
    	h1.next = h2;
    	h2.next = h3;
    	h3.next = h4;
    	h4.next = h5;
    	h5.next = h6;
    	h6.next = null;
    	h1 = deleteDuplicates(h1);
    	while(h1 != null){
    		System.out.println(h1.val + "->");
    		h1 = h1.next;
    	}
    }
}