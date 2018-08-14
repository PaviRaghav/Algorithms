/*
Given inorder traversal of a tree, construct a cartesian tree (root value is greater than values of its children.)
*/

import java.util.*;

class CartesianTree {

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

	public TreeNode buildTree(ArrayList<Integer> A) {
		if (A.size() == 0)
			return null;
		if (A.size() == 1)
			return new TreeNode(A.get(0));
		// find max
		int i = 0, ind = 1;
		int temp = A.get(0);
		while (ind < A.size()) {
			if (A.get(ind) > temp) {
				temp = A.get(ind);
				i = ind;
			}
			ind++;
		}
		// separate two sub-trees
		ArrayList<Integer> AL = new ArrayList<Integer>(A.subList(0, i));
		// System.out.println("left: " + AL);
		ArrayList<Integer> AR = new ArrayList<Integer>(A.subList(i + 1, A.size()));
		// System.out.println("right: " + AR);
		TreeNode root = new TreeNode(A.get(i));
		root.left = buildTree(AL);
		root.right = buildTree(AR);
		return root;
	}

	private void printInorder(TreeNode node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}
}
