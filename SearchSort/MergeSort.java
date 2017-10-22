package Algorithms;

import Implementation.*;

public class MergeSort {
	public SLL_LinkNode sortList(SLL_LinkNode head) {
		if (head.getNext() == null)
			return head;
		// split the list recursively
		SLL_LinkNode ptr1 = head, ptr2 = head;
		while (ptr2 != null && ptr2.getNext() != null && ptr2.getNext().getNext() != null) {
			ptr1 = ptr1.getNext();
			ptr2 = ptr2.getNext().getNext();
		}
		SLL_LinkNode head2 = ptr1.getNext();
		ptr1.setNext(null);
		head=sortList(head);
		head2=sortList(head2);
		head = merge(head, head2);
		
		// merge

		return head;
	}

	public SLL_LinkNode merge(SLL_LinkNode head1, SLL_LinkNode head2) {
		SLL_LinkNode head = new SLL_LinkNode(0), loop = head, temp;
		while (head1 != null && head2 != null) {
			if (head1.getData() < head2.getData()) {
				temp = head1.getNext();
				loop.setNext(head1);
				head1 = temp;
			} else {
				temp = head2.getNext();
				loop.setNext(head2);
				head2 = temp;
			}
			loop = loop.getNext();
		}
		if (head1 == null)
			loop.setNext(head2);
		if (head2 == null)
			loop.setNext(head1);
		return head.getNext();
	}
}
