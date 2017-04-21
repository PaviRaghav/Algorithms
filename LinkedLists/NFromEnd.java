package Algorithms;

/**
 * This is a class to find the nth node from the end of a singly linked list.
 * Brute-force for this would be to loop through the list and find the length, 
 * find length-n+1, and then loop through again to that location.
 * But this class implements it in just one scan.
 * 2 pointers, say A and B, start at the head node; the width between them should be n; 
 * A waits at head until B reaches nth node; then they both start traversing the list together 
 * until B reaches the end; A is the nth node from the end.
 * @author Pavithra Raghavan 
 */

import Implementation.*;

public class NFromEnd {
	public SLL_LinkNode findNthFromEnd(SLL_LinkNode head, int n) {
		// pre: there are more than n nodes in the linked list
		// post: returns the 'n'th node from the end of the list
		SLL_LinkNode A = head, B = head;
		// B to reach the 'n'th location:
		for (int i = 1; i < n; i++) {
			// handling n>length
			if (B.getNext() != null)
				B = B.getNext();
			else
				return null;
		}
		// n==length
		if (B.getNext() == null)
			return head;

		// A and B maintain a width of n:
		do {
			A = A.getNext();
			B = B.getNext();
		} while (B.getNext() != null);
		return A;
	}
}
