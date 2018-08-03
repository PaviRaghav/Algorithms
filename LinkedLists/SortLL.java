public class SortLL {
	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode sortList(ListNode A) {
		ListNode pt1 = A, pt2 = A;
		if (A.next == null)
			return A;
		if(pt1.next.next == null)
			pt2 = pt2.next;
		while (pt2.next != null && pt2.next.next != null) {
			pt2 = pt2.next.next;
			pt1 = pt1.next;
		}
		ListNode B = pt1.next;
		pt1.next = null;
		
		ListNode left = sortList(A);
		ListNode right = sortList(B);
		return mergeList(left, right);
	}

	private ListNode mergeList(ListNode A, ListNode B) {
		ListNode pt1 = A, pt2 = B, curr = new ListNode(-1), head = curr;
		while (pt1 != null && pt2 != null) {
			if (pt1.val <= pt2.val) {
				curr.next = pt1;
				pt1 = pt1.next;
			} else {
				curr.next = pt2;
				pt2 = pt2.next;
			}
			curr = curr.next;
		}
		if (pt1 != null)
			curr.next = pt1;
		else
			curr.next = pt2;
		return head.next;
	}
}
