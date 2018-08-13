import java.util.*;

class ConnectNext {

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		Deque<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		if (root == null)
			return;
		// q.addFirst(root);
		q.addFirst(null);
		TreeLinkNode prev = root;
		TreeLinkNode curr = null;
		while (!q.isEmpty()) {
			curr = q.removeLast();
			if (prev == null && curr == null)
				break;
			if (prev != null)
				prev.next = curr;
			if (curr != null) {
				if (curr.left != null)
					q.addFirst(curr.left);
				if (curr.right != null)
					q.addFirst(curr.right);
			} else {
				if (prev == root) {
					if (root.left != null)
						q.addFirst(root.left);
					if (root.right != null)
						q.addFirst(root.right);
				}
				q.addFirst(null);
			}
			prev = curr;
		}
	}
}
