package Algorithms;
/**
 * This is a class to find if a given linked list ends in a loop.
 * If at all a list ends in a loop, two nodes will be pointing to the same node 
 * (i.e.) their 'next' will be the same.
 * Brute-force for this is to create a hash table and see if any address is repeated.
 * An efficient algorithm is Floyd's. This uses two pointers, one slow and one fast.
 * The fast one would catch up with the slow one only if there's a loop.
 * @author Pavithra Raghavan 
 */

import Implementation.*;

public class LoopAtEnd {
	public boolean checkForLoop(SLL_LinkNode slow) {
		SLL_LinkNode fast = slow;
		while (fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if (fast == slow)
				return true;
		}
		return false;
	}
}