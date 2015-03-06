/**
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4,  you should return the list as 2->1->4->3

Your algorithm should use only constant space. 
You may not modify the values in the list, only nodes itself can be changed.

 */

public class SwapNodesInPairs {
	 public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	 }
	 
    public static ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null)) return head;
        ListNode newhead, t0, t1, t2;
        t1 = head;
        t2 = head.next;
        t1.next = t2.next;
        t2.next = t1;
        newhead = t2;
        t0 = t1;
        t1 = t1.next;
        while(t1 != null && t1.next != null){
        	t2 = t1.next;
        	t1.next = t2.next;
        	t2.next = t1;
        	t0.next = t2;
        	t0 = t1;
        	t1 = t1.next;
        }
        return newhead;
    }
    
    public static ListNode swapPairs2(ListNode head) {
    	if ((head == null) || (head.next == null)) return head;
    	
    	ListNode fakehead = new ListNode(-1);
    	fakehead.next = head;
    	ListNode pre = fakehead, cur = head;
    	
    	while (cur != null && cur.next != null) {
    		ListNode nextstart = cur.next.next;
    		cur.next.next = cur;
    		pre.next = cur.next;
    		cur.next = nextstart;
    		pre = cur;
    		cur = cur.next;
    	}
    	return fakehead.next;
    }
    
    public static void main(String args[]) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	ListNode n5 = new ListNode(5);
    	ListNode n6 = new ListNode(6);
    	ListNode n7 = new ListNode(7);
    	ListNode head;
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	n4.next = n5;
    	n5.next = n6;
    	n6.next = n7;
    	n7.next = null;
    	head = swapPairs(n1);
    	while(head != null) {
    		System.out.println(head.val + "->");
    		head = head.next;
    	}
    }
}