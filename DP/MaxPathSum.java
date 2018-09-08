import java.util.*;

/*
 
 Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.

 */
 
class MaxPathSum {

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

	public int maxPathSum(TreeNode A) {
		if (A == null)
			return 0;
		HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
		maxPathSum(A, map);
		int max = Integer.MIN_VALUE;
		for (TreeNode a : map.keySet())
			max = Math.max(max, map.get(a));
		return max;
	}

	private int maxPathSum(TreeNode A, HashMap<TreeNode, Integer> map) {
		int x = 0;
		if (!map.containsKey(A)) {
			if (A.left == null && A.right == null) {
				map.put(A, A.val);
				x = A.val;
			} else {
				int value;
				int left = 0;
				int right = 0;
				if (A.left != null)
					left = maxPathSum(A.left, map);
				if (A.right != null)
					right = maxPathSum(A.right, map);
				value = Math.max(Math.max(A.val + right, A.val + left + right), Math.max(A.val + left, A.val));
				map.put(A, value);
				x = Math.max(A.val + right, Math.max(A.val + left, A.val));
			}
		}
		return x;
	}
}
