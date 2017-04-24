/**
 * This is a class to find the meeting node of two linked lists.
 */
package Algorithms;

import Implementation.*;

public class LLMeetingPt {
	public SLL_LinkNode MeetingPt(SLL_LinkNode node1, SLL_LinkNode node2) {
		SLL_LinkNode head1 = node1, head2 = node2;
		int l1 = 0, l2 = 0, d = 0;
		while (head1 != null) {
			l1++;
			head1 = head1.getNext();
		}
		while (head2 != null) {
			head2 = head2.getNext();
			l2++;
		}
		if (l1 < l2) {
			d = l2 - l1;
			head1 = node2;
			head2 = node1;
		} else if (l1 > l2) {
			d = l1 - l2;
			head1 = node1;
			head2 = node2;
		}
		if (d != 0) {
			for (int i = 1; i <= d; i++)
				head1 = head1.getNext();
		}
		while (head1 != null) {
			if (head1 == head2)
				return head1;
			else {
				head1 = head1.getNext();
				head2 = head2.getNext();
			}
		}
		return null;
	}
}
