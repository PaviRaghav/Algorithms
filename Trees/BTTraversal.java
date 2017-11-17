package Algorithms;

import java.util.*;

import Implementation.BinaryTreeNode;
import Implementation.Q_DynArray;
import Implementation.Stack_DynArray;

public class BTTraversal {

	public void PreOrder(BinaryTreeNode root) {
		if (root != null) {
			System.out.println(root.getData());
			PreOrder(root.getLeft());
			PreOrder(root.getRight());
		}
	}

	public void ite_preorder(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack_DynArray<BinaryTreeNode> stk = new Stack_DynArray<BinaryTreeNode>();
		try {
			stk.push(root);
			while (!stk.isEmpty()) {
				BinaryTreeNode temp = stk.pop();
				System.out.println(temp.getData());
				if (temp.getRight() != null)
					stk.push(temp.getRight());
				if (temp.getLeft() != null)
					stk.push(temp.getLeft());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void InOrder(BinaryTreeNode root) {
		if (root != null) {
			InOrder(root.getLeft());
			System.out.println(root.getData());
			InOrder(root.getRight());
		}
	}

	public void ite_inorder(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack_DynArray<BinaryTreeNode> stk = new Stack_DynArray<BinaryTreeNode>();
		try {
			boolean flag = true;
			stk.push(root);
			while (!stk.isEmpty()) {
				BinaryTreeNode temp = stk.top();
				if (temp.getLeft() != null && flag)
					stk.push(temp.getLeft());
				else {
					flag = false;
					temp = stk.pop();
					System.out.println(temp.getData());
					if (temp.getRight() != null) {
						stk.push(temp.getRight());
						flag = true;
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void PostOrder(BinaryTreeNode root) {
		if (root != null) {
			PostOrder(root.getLeft());
			PostOrder(root.getRight());
			System.out.println(root.getData());
		}
	}

	public void ite_PostOrder(BinaryTreeNode root) {
		try {
			Stack_DynArray<BinaryTreeNode> stk = new Stack_DynArray<BinaryTreeNode>();
			stk.push(root);
			BinaryTreeNode curr, prev = null;
			while (!stk.isEmpty()) {
				curr = stk.top();
				if (prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
					if (curr.getLeft() != null)
						stk.push(curr.getLeft());
					else if (curr.getRight() != null)
						stk.push(curr.getRight());
				} else if (curr.getLeft() == prev) {
					if (curr.getRight() != null)
						stk.push(curr.getRight());
				} else {
					System.out.println(curr.data);
					stk.pop();
				}
				prev = curr;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void levelOrderTraversal(BinaryTreeNode root) {
		Q_DynArray<BinaryTreeNode> q = new Q_DynArray<BinaryTreeNode>();
		if (root == null)
			return;
		q.Enqueue(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.Dequeue();
			System.out.println(temp.getData());
			if (temp.getLeft() != null)
				q.Enqueue(temp.getLeft());
			if (temp.getRight() != null)
				q.Enqueue(temp.getRight());
		}
	}

	public void reverseLevelOrderTraversal(BinaryTreeNode root) {
		Q_DynArray<BinaryTreeNode> q = new Q_DynArray<BinaryTreeNode>();
		Stack_DynArray<BinaryTreeNode> stk = new Stack_DynArray<BinaryTreeNode>();
		if (root == null)
			return;
		try {
			while (!q.isEmpty()) {
				BinaryTreeNode temp = q.Dequeue();
				stk.push(temp);
				if (temp.getLeft() != null)
					q.Enqueue(temp.getRight());
				if (temp.getRight() != null)
					q.Enqueue(temp.getLeft());
			}
			while (!stk.isEmpty())
				System.out.println(stk.pop() + " ");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void zigzagTreeTraversal(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stk1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> stk2 = new Stack<BinaryTreeNode>();
		// root into q, 1st into stk, 2nd into queue
		stk1.push(root);
		BinaryTreeNode temp;
		while (!stk1.isEmpty() || !stk2.isEmpty()) {
			while (!stk1.isEmpty()) {
				temp = stk1.pop();
				System.out.print(temp.data + " ");
				if (temp.left != null)
					stk2.push(temp.left);
				if (temp.right != null)
					stk2.push(temp.right);
			}
			while (!stk2.isEmpty()) {
				temp = stk2.pop();
				System.out.print(temp.data + " ");
				if (temp.right != null)
					stk1.push(temp.right);
				if (temp.left != null)
					stk1.push(temp.left);
			}
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
		root.left.left.left = new BinaryTreeNode(8);
		root.left.left.right = new BinaryTreeNode(9);
		root.left.right.left = new BinaryTreeNode(10);
		root.left.right.right = new BinaryTreeNode(11);
		root.right.left.left = new BinaryTreeNode(12);
		root.right.left.right = new BinaryTreeNode(13);
		root.right.right.left = new BinaryTreeNode(14);
		root.right.right.right = new BinaryTreeNode(15);
		BTTraversal obj = new BTTraversal();
		obj.zigzagTreeTraversal(root);
	}
}
