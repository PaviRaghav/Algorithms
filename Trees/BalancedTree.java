import java.util.*;

class BalancedTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public int isBalanced(TreeNode A) {
		if (A == null)
			return 0;
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		q.addFirst(A);
		while (!q.isEmpty()) {
			TreeNode curr = q.removeLast();
			if (depth(curr.left) != depth(curr.right) && depth(curr.left) - depth(curr.right) != 1
					&& depth(curr.left) - depth(curr.right) != -1)
				return 0;
			if (curr.left != null)
				q.addFirst(curr.left);
			if (curr.right != null)
				q.addFirst(curr.right);
		}
		return 1;
	}

	private int depth(TreeNode A) {
		if (A == null)
			return 0;
		if (A.left == null && A.right == null)
			return 1;
		if (A.left == null)
			return 1 + depth(A.right);
		if (A.right == null)
			return 1 + depth(A.left);
		return 1 + Math.max(depth(A.left), depth(A.right));
	}
}
