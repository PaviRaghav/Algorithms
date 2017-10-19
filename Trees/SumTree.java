package Algorithms;

import Implementation.BinaryTreeNode;

public class SumTree {
	public boolean isLeaf(BinaryTreeNode root) {
		if (root.getLeft() == null && root.getRight() == null)
			return true;
		else
			return false;
	}

	public boolean isSumTree(BinaryTreeNode root) {
		// base case
		if (root == null || isLeaf(root))
			return true;

		int left, right;
		if (root.getLeft() != null) {
			if (isLeaf(root.getLeft()))
				left = root.getLeft().getData();
			else
				left = 2 * root.getLeft().getData();
		} else
			left = 0;
		if (root.getRight() != null) {
			if (isLeaf(root.getRight()))
				right = root.getRight().getData();
			else
				right = 2 * root.getRight().getData();
		} else
			right = 0;

		// recursive call
		// return statement
		return ((root.getData() == (left + right)) && isSumTree(root.getLeft()) && isSumTree(root.getRight()));

	}
}
