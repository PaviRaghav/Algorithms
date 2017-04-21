package Algorithms;

import Implementation.*;

public class ReverseLL {
	private SLL_LinkNode head;

	public SLL_LinkNode Iterative_ReverseLL(SLL_LinkNode head) {
		/*
		 * 1 2 3 4 5 null pre: head node of the Singly LL post: head node should
		 * be the last node pointing to null and new head node is the last node
		 */
		SLL_LinkNode prev = null, curr = head, next = head;
		while (next != null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			if (next != null)
				curr = next;
		}
		return curr;
	}

	public SLL_LinkNode Recursive_ReverseLL(SLL_LinkNode curr, SLL_LinkNode prev) {
		if (curr.getNext() == null) {
			head = curr;
			curr.setNext(prev);
			return null;
		}
		SLL_LinkNode next = curr.getNext();
		curr.setNext(prev);
		Recursive_ReverseLL(next, curr);
		return head;
	}
}
