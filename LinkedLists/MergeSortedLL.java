/**
 * This class is to merge two sorted lists into one linked list.
 * @author Pavithra Raghavan
 */
package Algorithms;

import Implementation.*;

public class MergeSortedLL {

	

	public SLL_LinkNode rec_mergeSorted(SLL_LinkNode head1, SLL_LinkNode head2) {
		// recursive
		SLL_LinkNode curr = new SLL_LinkNode(0);
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		if(head1.getData() <= head2.getData()) {
			curr = head1;
			curr.setNext(rec_mergeSorted(head1.getNext(), head2));
		}
		else  {
			curr = head2;
			curr.setNext(rec_mergeSorted(head2.getNext(), head1));
		} 
		return curr;
	}

	public SLL_LinkNode it_mergeSorted(SLL_LinkNode head1, SLL_LinkNode head2) {
		// iterative
		SLL_LinkNode head = new SLL_LinkNode(0);
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		SLL_LinkNode curr = head;
		while (head1 != null && head2 != null) {
			if (head1.getData() < head2.getData()) {
				curr.setNext(head1);
				head1 = head1.getNext();
			} else {
				curr.setNext(head2);
				head2 = head2.getNext();
			}
			curr = curr.getNext();
		}
		if (head1 == null)
			curr.setNext(head2);
		if (head2 == null)
			curr.setNext(head1);
		return head.getNext();
	}
}
