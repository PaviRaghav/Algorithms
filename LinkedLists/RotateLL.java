package Algorithms;

import Implementation.*;

public class RotateLL {
	public SLL_LinkNode rotateLL(SLL_LinkNode head, int k) {
		SLL_LinkNode temp = head, newhead;
		for (int i = 0; i < k; i++) {
			if (temp.getNext() == null)
				return null;
			temp = temp.getNext();
		}
		newhead = temp.getNext();
		temp.setNext(null);
		temp = newhead;
		while (temp.getNext() != null)
			temp = temp.getNext();
		temp.setNext(head);
		return newhead;
	}
}
