package Algorithms;

import Implementation.*;

public class DeDup {
	public SLL_LinkNode dedupLL(SLL_LinkNode head) {
		if (head == null)
			return null;
		SLL_LinkNode newhead = new SLL_LinkNode();
		newhead.setNext(head);
		SLL_LinkNode check= head, loop, prev = newhead;
		while (check!= null) {
			for (loop = check.getNext(); loop != null; loop = loop.getNext()) {
				if (check.getData() == loop.getData()) {
					prev.setNext(check.getNext());
					check.setNext(null);
					check = prev;
					break;
				}
			}
			prev = check;
			check = check.getNext();
		}
		return newhead.getNext();
	}
}
