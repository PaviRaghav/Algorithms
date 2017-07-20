package Algorithms;

import Implementation.*;

public class DeDup {
	public SLL_LinkNode dedupLL(SLL_LinkNode head) {
		if (head == null)
			return null;
		boolean changed = false;
		SLL_LinkNode newhead = new SLL_LinkNode();
		newhead.setNext(head);
		SLL_LinkNode check, loop, prev = newhead;
		for (check = head; check != null; check = check.getNext()) {
			for (loop = check.getNext(); loop != null; loop = loop.getNext()) {
				if (check.getData() == loop.getData()) {
					prev.setNext(check.getNext());
					check.setNext(null);
					check = prev;
					changed = true;
					break;
				}
			}
			if (!changed) 
				prev = prev.getNext();
			changed = false;
		}
		return newhead.getNext();
	}
}
