package Algorithms;

import Implementation.*;
/**
 * return the last node whose node number is divisible by k 
 * @author pavithraraghavan
 *
 */
public class ModularNodes {
	public SLL_LinkNode modularNodes(SLL_LinkNode head, int k) {
		SLL_LinkNode modularNode = null;
		if (k <= 0)
			return null;
		int i = 0;
		for (; head != null; head = head.getNext()) {
			if (i % k == 0)
				modularNode = head;
			i++;
		}

		return modularNode;
	}
	
}
