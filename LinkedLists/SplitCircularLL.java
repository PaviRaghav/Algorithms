package Algorithms;

import Implementation.*;

public class SplitCircularLL {
	public SLL_LinkNode splitCircular(SLL_LinkNode head) {
		SLL_LinkNode ptr1 = head, ptr2 = head;
		if (ptr1.getNext() != ptr1)
			ptr1 = ptr1.getNext();
		else
			return head;

		if (ptr1.getNext() != head)
			ptr2 = ptr2.getNext().getNext();

		while (ptr2.getNext() != head && ptr2.getNext().getNext() != head) {
			ptr1 = ptr1.getNext();
			ptr2 = ptr2.getNext().getNext();
		}
		if (ptr2.getNext() == head)
			ptr2.setNext(null);
		else
			ptr2.getNext().setNext(null);
		ptr2 = ptr1.getNext();
		ptr1.setNext(null);
		return ptr2;
	}
}
