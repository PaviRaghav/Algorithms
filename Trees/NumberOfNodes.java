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

	public static int noOfFullNodes(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int count = 0;
		Q_DynArray<BinaryTreeNode> q = new Q_DynArray<BinaryTreeNode>();
		q.Enqueue(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.Dequeue();
			if (temp.getLeft() != null && temp.getRight() != null)
				count++;
			if (temp.getLeft() != null)
				q.Enqueue(temp.getLeft());
			if (temp.getRight() != null)
				q.Enqueue(temp.getRight());
		}
		return count;
	}

	private static int diameter = 0;

	public static int diameterOfTree(BinaryTreeNode root) {
		//longest distance between two leaves in a tree
		if (root == null)
			return 0;
		int left, right, diameter = 0;
		left = diameterOfTree(root.getLeft());
		right = diameterOfTree(root.getRight());
		if (diameter < left + right + 1)
			diameter = left + right + 1;
		System.out.println(diameter);
		return Math.max(left, right) + 1;
	}

	public static int widthOfTree(BinaryTreeNode root) {
		//maximum number of nodes on a level of the tree
		if (root == null)
			return 0;
		Q_DynArray<BinaryTreeNode> q = new Q_DynArray<BinaryTreeNode>();
		q.Enqueue(root);
		q.Enqueue(null);
		int width = 1, level_width = 1;
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.Dequeue();
			if (temp == null) {
				if (!q.isEmpty())
					q.Enqueue(null);
				if (width < level_width)
					width = level_width;
				level_width = 0;
			} else {
				if (temp.getLeft() != null) {
					q.Enqueue(temp.getLeft());
					level_width++;
				}
				if (temp.getRight() != null) {
					q.Enqueue(temp.getRight());
					level_width++;
				}
			}
		}
		return width;
	}

	public static boolean sumExists(BinaryTreeNode root, int sum) {
		if (root == null)
			return false;
		int total = root.getData();
		total = total(root, sum);
		if (total == sum)
			return true;
		else
			return false;
	}

	public static int total(BinaryTreeNode root, int sum) {
		// find if the given sum exists in the tree
		if (root == null)
			return 0;
		int total = root.getData();
		try {
			Stack_DynArray<BinaryTreeNode> stk = new Stack_DynArray<BinaryTreeNode>();
			boolean flag = false;
			BinaryTreeNode curr = root, prev = null;
			while (!flag) {

				if (sum == total)
					return total;
				if (curr != null && curr != prev) {
					stk.push(curr);
					total += curr.getData();
					curr = curr.getLeft();
				} else {
					if (stk.isEmpty())
						flag = true;
					else {
						BinaryTreeNode temp = stk.top();
						if (curr == temp.getRight()) {
							temp = stk.pop();
							total -= temp.getData();
							prev = temp;
							curr = stk.top();
						}
						curr = curr.getRight();
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return total;
	}
}
