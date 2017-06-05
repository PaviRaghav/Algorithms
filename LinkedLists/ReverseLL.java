package Algorithms;

import Implementation.*;

/**
 * This is a class to reverse a Linker list (part or whole)
 * 
 * @author Pavithra Raghavan
 */
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
		// reversing LL recursively
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

	public void reversePart(SLL_LinkNode head, int start, int end) {
		// reversing part of the linked list
		if (end <= start)
			return;
		if (start <= 1)
			start = 1;
		// if(end>=length) end=length;
		for (int i = 1; i < start - 1; i++)
			head = head.getNext();
		SLL_LinkNode prev = head.getNext(), curr = head.getNext(), next = head;
		for (int i = start; i <= end + 1; i++) {
			if (next != null)
				curr = next;
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
		}
		head.getNext().setNext(next);
		head.setNext(curr);
	}

	public SLL_LinkNode ite_reverseInPairs(SLL_LinkNode head) {
		// reversing the linked list in pairs iteratively
		SLL_LinkNode temp1, temp2, new_head = head.getNext();
		while (head != null && head.getNext() != null) {
			temp1 = head.getNext();
			temp2 = temp1.getNext();
			if (temp2 == null || temp2.getNext() == null)
				head.setNext(temp2);
			else
				head.setNext(temp2.getNext());
			temp1.setNext(head);
			head = temp2;

		}
		return new_head;
	}

	public SLL_LinkNode rec_reverseInPairs(SLL_LinkNode head) {
		// reversing the linked list in pairs recursively
		if (head == null || head.getNext() == null)
			return head;
		SLL_LinkNode temp = head.getNext();
		head.setNext(temp.getNext());
		temp.setNext(head);
		head = temp;
		head.getNext().setNext(rec_reverseInPairs(head.getNext().getNext()));
		return head;
	}

	public SLL_LinkNode rec_reverseBlocks(SLL_LinkNode head, int block) {
		// reverse in blocks recursively
		SLL_LinkNode curr = head;
		SLL_LinkNode next = null;
		SLL_LinkNode prev = null;
		int count = block;
		while (curr != null && count > 0) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
			count--;
		}
		if (next != null)
			head.setNext(rec_reverseBlocks(next, block));
		return prev;
	}
/*
	public SLL_LinkNode ite_reverseBlocks(SLL_LinkNode head, int block) {
		// reverse in blocks iteratively
		SLL_LinkNode curr = head, head_prev = head, head_new = null;
		SLL_LinkNode next = null;
		SLL_LinkNode prev = null;
		int count = block;
		while (next != null) {
			while (curr != null && count > 0) {
				next = curr.getNext();
				curr.setNext(prev);
				prev = curr;
				curr = next;
				count--;
			}
			head_new = prev;
			count = block;
		}
		return null;
	}
	*/
}
