// Merge two sorted linked lists and return it as a new list. 
// The new list should be made by splicing together the nodes of the first two lists.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class MergeSortedLists {
	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	 
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head, l3;
        if (l1 == null && l2 == null) { 
        	return null;
        }
        else if (l1 == null) { 
        	return l2;
        }
        else if (l2 == null){
        	return l1;
        }
        
        if (l1.val <= l2.val) {
        	l3 = l1;
        	l1 = l1.next;
        } else {
        	l3 = l2;
        	l2 = l2.next;
        }
        head = l3;
        
        while (l1!=null || l2!=null) {
        	if (l1!=null && l2!=null) {
        		if (l1.val <= l2.val) {
        			l3.next = l1;
        			l1 = l1.next;
        		} else {
        			l3.next = l2;
        			l2 = l2.next;
        		}
        	} else if (l1!=null) {
        		l3.next = l1;
        		l1 = l1.next;
        	} else {
        		l3.next = l2;
        		l2 = l2.next;
        	}
    		l3 = l3.next;        	
        }
        return head;
    }
    
    public static void main (String args[]){
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(3);
    	ListNode n3 = new ListNode(4);
    	ListNode n11 = new ListNode(0);
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = null;
    	n11.next = null;
    	ListNode head = mergeTwoLists(n1, n11);
    	while(head != null) {
    		System.out.println(head.val + "->");
    		head = head.next;
    	}
    }
}