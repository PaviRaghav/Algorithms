package Algorithms;

import Implementation.*;

public class Compare {
	public static boolean checkStructurallySame(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		else if (root1 != null && root2 != null) {
			return checkStructurallySame(root1.getLeft(), root2.getLeft())
					&& checkStructurallySame(root1.getRight(), root2.getRight());
		} else
			return false;
	}
}
