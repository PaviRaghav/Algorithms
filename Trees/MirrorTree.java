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
}
