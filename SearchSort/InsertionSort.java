package Algorithms;

import Implementation.*;

public class InsertionSort {
	public int[] insertionSort(int[] A) {
		for (int j = 1; j < A.length; j++) {
			int key = A[j];
			int i;
			for (i = j - 1; i >= 0; i--) {
				if (key > A[i])
					break;
				else
					A[i + 1] = A[i];
			}
			A[i + 1] = key;
		}
		return A;
	}

	public SLL_LinkNode insertionSort(SLL_LinkNode head) {
		// 2->1->5->3->0->6->2->null
		if (head == null)
			return null;
		SLL_LinkNode pass = head, comp = head,  key = head.getNext();
		while (pass.getNext() != null) {
			for (comp = head; comp.getNext() != key && comp.getNext().getData() < key.getData(); comp = comp.getNext())
				;
			if (comp == head && comp.getData() > key.getData()) {
				pass.setNext(key.getNext());
				key.setNext(head);
				head = key;
			} else if (comp.getNext() != key) {
				// insert key after comp
				pass.setNext(key.getNext());
				key.setNext(comp.getNext());
				comp.setNext(key);
			} else {
				pass=pass.getNext();
			}
			key = pass.getNext();
		}
		return head;
	}

	public static void main(String[] args) {
		// 2->1->5->3->0->6->2->null
		SLL_LinkNode head = new SLL_LinkNode(2);
		head.setNext(new SLL_LinkNode(1));
		head.getNext().setNext(new SLL_LinkNode(5));
		head.getNext().getNext().setNext(new SLL_LinkNode(3));
		head.getNext().getNext().getNext().setNext(new SLL_LinkNode(0));
		head.getNext().getNext().getNext().getNext().setNext(new SLL_LinkNode(6));
		head.getNext().getNext().getNext().getNext().getNext().setNext(new SLL_LinkNode(2));
		head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(null);
		SLL_LinkNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.getNext();
		}
		System.out.println();
		InsertionSort obj = new InsertionSort();
		SLL_LinkNode newhead = obj.insertionSort(head);
		temp = newhead;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.getNext();
		}
	}
}
