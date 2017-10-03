package Algorithms;

import Implementation.*;

public class MirrorTree {
	public static BinaryTreeNode mirrorTree(BinaryTreeNode root) {
		if (root != null) {
			mirrorTree(root.left);
			mirrorTree(root.right);
			BinaryTreeNode temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
		}
		return root;
	}

	public static boolean checkIfMirror(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
			return false;
		if (root1.getData() == root2.getData()) {
			return checkIfMirror(root1.getLeft(), root2.getRight()) || checkIfMirror(root1.getRight(), root2.getLeft());
		} else
			return false;
	}
}
