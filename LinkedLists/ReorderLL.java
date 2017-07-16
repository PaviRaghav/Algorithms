package Algorithms;

import Implementation.*;
/**
 * this class is for reordering L1-->L2-->L3-->....-->L(n-1) --> L(n)
 * to L1-->L(n)-->L2-->L(n-1)-->.... 
 * @author pavithraraghavan
 *
 */

public class ReorderLL {
	public void reorderLL(SLL_LinkNode head) {
		SLL_LinkNode ptr1 = head, ptr2 = head;
		while (ptr2.getNext() != null && ptr2.getNext().getNext() != null) {
			ptr1 = ptr1.getNext();
			ptr2 = ptr2.getNext().getNext();
		}

		// splitting the LL into two halves:
		ptr2 = ptr1.getNext(); // ptr2 is the head for the second half
		ptr1.setNext(null);

		// reversing the second half:
		ReverseLL obj = new ReverseLL();
		ptr1 = obj.Iterative_ReverseLL(ptr2); // ptr1 is the head for the
												// reversed second half

		// link the 2 halves:
		rec_linkLL(head,ptr1);
	}

	public SLL_LinkNode rec_linkLL(SLL_LinkNode head1, SLL_LinkNode head2) {
		SLL_LinkNode temp1 = head1.getNext(), temp2 = head2.getNext();
		head1.setNext(head2);
		if (temp2 != null)
			head2.setNext(rec_linkLL(temp1, temp2));
		else
			head2.setNext(temp1);
		return head1;
	}
}
