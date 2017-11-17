package Algorithms;

import java.util.*;

import Implementation.*;

public class MirrorTree {
	public BinaryTreeNode mirrorTree(BinaryTreeNode root) {
		if (root != null) {
			mirrorTree(root.left);
			mirrorTree(root.right);
			BinaryTreeNode temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
		}
		return root;
	}

	public boolean checkIfMirror(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
			return false;
		if (root1.getData() == root2.getData()) {
			return checkIfMirror(root1.getLeft(), root2.getRight()) || checkIfMirror(root1.getRight(), root2.getLeft());
		} else
			return false;
	}

	public void leftView(BinaryTreeNode root) {
		boolean flag = false;
		Deque<BinaryTreeNode> q1 = new LinkedList<BinaryTreeNode>();
		Deque<BinaryTreeNode> q2 = new LinkedList<BinaryTreeNode>();
		q1.addFirst(root);
		BinaryTreeNode temp;
		while (!q1.isEmpty()) {
			while (!q1.isEmpty()) {
				temp = q1.removeLast();
				if (!flag) {
					System.out.print(temp.data + " ");
					flag = true;
				}
				if (temp.left != null)
					q2.addFirst(temp.left);
				if (temp.right != null)
					q2.addFirst(temp.right);
			}
			q1.addAll(q2);
			q2.clear();
			flag = false;
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(6);
		root.right.right = new BinaryTreeNode(7);
		// root.left.left.left = new BinaryTreeNode(8);
		// root.left.left.right = new BinaryTreeNode(9);
		root.left.right.left = new BinaryTreeNode(10);
		root.left.right.right = new BinaryTreeNode(11);
		root.right.left.left = new BinaryTreeNode(12);
		root.right.left.right = new BinaryTreeNode(13);
		root.right.right.left = new BinaryTreeNode(14);
		root.right.right.right = new BinaryTreeNode(15);
		MirrorTree obj = new MirrorTree();
		obj.leftView(root);
	}
}
