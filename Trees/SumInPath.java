package Algorithms;

import Implementation.BinaryTreeNode;

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
}
