package Algorithms;

import Implementation.*;

public class JosephusCircle {
	public SLL_LinkNode josephusCircle(SLL_LinkNode head, int M) {
		SLL_LinkNode ptr1 = head;
		if (head.getNext() != head)
			ptr1 = head.getNext();
		else
			return head;
		
		while(ptr1.getNext()!=ptr1) {
			for(int i=1; i<M-1; i++) {
				ptr1=ptr1.getNext();
			}
			ptr1.setNext(ptr1.getNext().getNext());
			ptr1=ptr1.getNext();
		}
		return ptr1;
	}
}
