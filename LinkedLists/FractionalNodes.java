package Algorithms;

import Implementation.*;

public class FractionalNodes {
	public SLL_LinkNode fractionalNode(SLL_LinkNode head, int k) {
		SLL_LinkNode fractionalNode = null;
		if (k <= 0)
			return null;
		int i = 1;
		for (; fractionalNode == null && head!=null; head = head.getNext()) {
			if (i % k == 0)
				fractionalNode = head;
			i++;
		}

		return fractionalNode;
	}
}
