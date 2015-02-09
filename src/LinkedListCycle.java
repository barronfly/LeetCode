/**
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/

public class LinkedListCycle {
	 // Definition for singly-linked list.
	 public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	 }
	 
	 public boolean hasCycle(ListNode head) {
		 ListNode slow, fast;
		 slow = fast = head;
		 while (slow!=null && fast!=null && fast.next!=null) {
			 slow = slow.next;
			 fast = fast.next.next;
			 if (slow == fast) return true;
		 }
		 return false;
	 }
	 
	 public static void main(String args[]) {
		 ListNode a1 = new ListNode(1);
		 ListNode a2 = new ListNode(2);
		 ListNode a3 = new ListNode(3);
		 ListNode a4 = new ListNode(4);
		 a1.next = a2;
		 a2.next = a3;
		 a3.next = a4;
		 a4.next = null;
		 //a4.next = a1;
		 LinkedListCycle llc = new LinkedListCycle();
		 System.out.println("The list has cycle: " + llc.hasCycle(a1));
	 }
}