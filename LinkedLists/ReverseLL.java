package Algorithms;
import Implementation.*;

public class ReverseLL {
	public SLL_LinkNode reverse_LL(SLL_LinkNode head) {
		/*
		 * pre: head node of the Singly LL 
		 * post: head node should be the last
		 *       node pointing to null and new head node is the last node
		 */
		SLL_LinkNode prev = null, curr = head, next = head;
		while (next != null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev=curr;
			if (next != null)
				curr = next;
		}
		return curr;
	}
}
