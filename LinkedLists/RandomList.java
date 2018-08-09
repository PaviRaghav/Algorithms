import java.math.BigInteger;
import java.util.*;

class RandomList {
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode curr = head, new_one = null, newHead = new RandomListNode(-1), prev_one = newHead;
		while (curr != null) {
			if (!map.containsKey(curr)) {
				new_one = new RandomListNode(curr.label);
				map.put(curr, new_one);
			}
			new_one = map.get(curr);
			if (curr.random != null && !map.containsKey(curr.random)) {
				RandomListNode new_rand = new RandomListNode(curr.random.label);
				map.put(curr.random, new_rand);
			}
			new_one.random = map.get(curr.random);
			prev_one.next = new_one;
			prev_one = new_one;
			curr = curr.next;
		}
		newHead.next = null;
		return map.get(head);
	}
}
