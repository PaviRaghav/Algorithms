package Algorithms;

import Implementation.*;

public class SumInPath {
	public static boolean hasPathSum(BinaryTreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && root.data == sum)
			return true;
		else
			return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
	}

	public static int sum(BinaryTreeNode root, int sum) {
		if (root == null)
			return 0;
		else {
			sum = root.getData() + sum(root.getLeft(), sum) + sum(root.getRight(), sum);
		}
		return sum;
	}

	public static int ite_sum(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int sum = 0;
		Q_DynArray<BinaryTreeNode> q = new Q_DynArray<BinaryTreeNode>();
		q.Enqueue(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.Dequeue();
			sum = sum + temp.getData();
			if (temp.getLeft() != null)
				q.Enqueue(temp.getLeft());
			if (temp.getRight() != null)
				q.Enqueue(temp.getRight());
		}
		return sum;
	}
}
