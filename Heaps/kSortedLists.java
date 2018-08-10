import java.util.*;

class kSortedLists {
	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	class Comp implements Comparator<ListNode> {
		public int compare(ListNode s1, ListNode s2) {
			if (s1.val > s2.val)
				return 1;
			else if (s1.val < s2.val)
				return -1;
			return 0;
		}
	}

	public ListNode mergeKLists(ArrayList<ListNode> a) {
		PriorityQueue<ListNode> PQ = new PriorityQueue<ListNode>(a.size(), new Comp());
		for (ListNode i : a)
			PQ.add(i);
		ListNode newHead = new ListNode(-1);
		ListNode curr, prev = newHead;
		while (!PQ.isEmpty()) {
			curr = PQ.remove();
			prev.next = curr;
			if (curr.next != null)
				PQ.add(curr.next);
			curr.next = null;
			prev = curr;
		}
		return newHead.next;
	}
}
