/*
Sum of numbers formed by digits from root to leaf.
*/

import java.util.*;

class SumNums {

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

	public int sumNumbers(TreeNode A) {
		Deque<TreeNode> q = new LinkedList<TreeNode>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		generate(res, A, 0);
		int result = 0;
		for (int i : res)
			result = (result + i) % 1003;
		return result;
	}

	private void generate(ArrayList<Integer> res, TreeNode A, long temp) {
		if (A.left == null && A.right == null)
			res.add((int) (((temp * 10) + A.val) % 1003));
		if (A.left != null)
			generate(res, A.left, ((temp * 10) + A.val) % 1003);
		if (A.right != null)
			generate(res, A.right, ((temp * 10) + A.val) % 1003);
	}
}
