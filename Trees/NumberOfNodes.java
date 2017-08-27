package Algorithms;

import Implementation.*;

public class NumberOfNodes {
	public static int noOfLeaves(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int count = 0;
		Q_DynArray<BinaryTreeNode> q = new Q_DynArray<BinaryTreeNode>();
		q.Enqueue(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.Dequeue();
			if (temp.getLeft() == null && temp.getRight() == null)
				count++;
			if (temp.getLeft() != null)
				q.Enqueue(temp.getLeft());
			if (temp.getRight() != null)
				q.Enqueue(temp.getRight());
		}
		return count;
	}
}
