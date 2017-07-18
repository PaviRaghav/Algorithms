package Algorithms;

import Implementation.*;

/**
 * This class is to add the individual elements of two LL's which are in reverse
 * order. 
 * LL1: 5-->7-->6-->null 
 * LL2: 2-->3-->3-->null 
 * output: 9-->0-->8-->null
 * summation in reverse order, but with single digit. Carry over is added to the
 * previous node.
 * 
 * @author pavithraraghavan
 */
public class AddElements {
	public SLL_LinkNode add(SLL_LinkNode head1, SLL_LinkNode head2) {
		// creating a new LL with summation as data elements:
		SLL_LinkNode newhead = new SLL_LinkNode(), curr = newhead, next;
		while (head1 != null && head2 != null) {
			next = new SLL_LinkNode(head1.getData() + head2.getData());
			curr.setNext(next);
			curr = next;
			head1 = head1.getNext();
			head2 = head2.getNext();
		}
		if (head1 == null) {
			curr.setNext(head2);
		}
		if (head2 == null) {
			curr.setNext(head1);
		}

		// Carry over:
		curr = newhead.getNext();
		int carry = 0;
		while (curr != null) {
			carry = curr.getData() / 10;
			curr.setData(curr.getData() % 10);
			next = curr.getNext();
			if (carry != 0 && next != null)
				next.setData(next.getData() + carry);
			else if (carry != 0 && next == null) {
				SLL_LinkNode new1 = new SLL_LinkNode(carry);
				curr.setNext(new1);
			}
			curr = next;
		}

		// Reverse the new LL:
		ReverseLL obj = new ReverseLL();
		newhead = obj.Iterative_ReverseLL(newhead.getNext());

		return newhead;
	}
}
