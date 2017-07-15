package Algorithms;

import Implementation.*;

public class Palindrome {
	public boolean isPalindrome(SLL_LinkNode head) {
		// travel to the mid link
		boolean isPalindrome = true;
		SLL_LinkNode ptr1 = head, ptr2 = head;
		while (ptr2.getNext() != null && ptr2.getNext().getNext() != null) {
			ptr1 = ptr1.getNext();
			ptr2 = ptr2.getNext().getNext();
		}
		ptr2 = ptr1;
		ptr1 = ptr1.getNext();
		ptr2.setNext(null);

		// reversing the 2nd half
		ReverseLL obj = new ReverseLL();
		ptr2 = obj.Iterative_ReverseLL(ptr1);
		SLL_LinkNode newhead = ptr2;
		ptr1 = head;
		while (ptr1 != null && ptr2 != null) {
			if (ptr1.getData() != ptr2.getData()) {
				isPalindrome = false;
				break;
			} else {
				ptr1 = ptr1.getNext();
				ptr2 = ptr2.getNext();
			}
		}

		// reconstructing original LL
		ptr1 = head;
		while (ptr1.getNext() != null)
			ptr1 = ptr1.getNext();
		ptr1.setNext(obj.Iterative_ReverseLL(newhead));

		return isPalindrome;
	}
}
