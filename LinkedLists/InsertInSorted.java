package Algorithms;

import Implementation.*;

public class InsertInSorted {
	public SLL_LinkNode addInSortedList(SLL_LinkNode head, int item) {
		SLL_LinkNode new_node = new SLL_LinkNode(item), ptr=head;
		while (ptr.getNext()!=null && ptr.getNext().getData() < item)
			ptr = ptr.getNext();
		if (ptr.getData() < item) {
			new_node.setNext(ptr.getNext());
			ptr.setNext(new_node);
			return head;
		} else {
			new_node.setNext(ptr);
			ptr = new_node;
			return ptr;
		}
	}
}
