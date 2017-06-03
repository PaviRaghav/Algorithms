/**
 * This class is to display a linked list in the reverse order
 * @author: Pavithra Raghavan
 */
package Algorithms;

import Implementation.*;

public class LLDispFromEnd {
	public void DispFromEnd(SLL_LinkNode head) {
		if (head == null)
			return;
		DispFromEnd(head.getNext());
		System.out.print(head.getData()+" ");
	}
}
