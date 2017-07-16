package Algorithms;

import Implementation.*;

public class SortingLL {
	public SLL_LinkNode insertionSort(SLL_LinkNode head) {
		SLL_LinkNode card = head.getNext(), node, card_prev = head, node_prev;
		while (card != null) {
			node = head;
			node_prev = head;
			while (node != card) {
				if (card.getData() < node.getData()) {
					card_prev.setNext(card.getNext());
					card.setNext(node);
					if (node == head)
						head = card;
					else
						node_prev.setNext(card);
					card = card_prev;
					break;
				} else {
					if (node != head.getNext())
						node_prev = node_prev.getNext();
					node = node.getNext();
				}
			}

			card = card.getNext();
			if (card_prev.getNext() != card)
				card_prev = card_prev.getNext();
		}

		return head;
	}
}
