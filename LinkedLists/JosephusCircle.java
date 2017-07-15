package Algorithms;

import Implementation.*;

public class JosephusCircle {
	public SLL_LinkNode josephusCircle(SLL_LinkNode head, int M) {
		SLL_LinkNode ptr1 = head, ptr2;
		if (ptr1.getNext() != head)
			ptr2 = head.getNext();
		else
			return head;
		
		while(ptr1.getNext()!=ptr1) {
			for(int i=1; i<M; i++) {
				ptr1=ptr1.getNext();
				ptr2=ptr1.getNext();
			}
			ptr1.setNext(ptr2.getNext());
		}
		return ptr1;
	}
}
