package Algorithms;

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

	public static void ite_preorder(BinaryTreeNode root) {
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

	public static void ite_inorder(BinaryTreeNode root) {
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

	public static void PostOrder(BinaryTreeNode root) {
		if (root != null) {
			PostOrder(root.getLeft());
			PostOrder(root.getRight());
			System.out.println(root.getData());
		}
	}

	public static void ite_PostOrder(BinaryTreeNode root) {
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

	public static void levelOrderTraversal(BinaryTreeNode root) {
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

	public static void reverseLevelOrderTraversal(BinaryTreeNode root) {
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

	@SuppressWarnings("unused")
	public static void ite_Post(BinaryTreeNode root) {
		Stack_DynArray<BinaryTreeNode> stk = new Stack_DynArray<BinaryTreeNode>();
		try {
			BinaryTreeNode curr, prev = null;
			stk.push(root);
			curr = stk.top();
			while (!stk.isEmpty()) {
				curr = stk.top();
				if (curr.getLeft() != null && (prev == null || prev.getLeft() == curr || prev.getRight() == curr)) {

					stk.push(curr.getLeft());
					prev = curr;
					// curr = curr.getLeft();
				} else if ((curr.getLeft() == null || curr.getLeft() == prev)
						&& (curr.getRight() != prev && curr.getRight() != null)) {
					stk.push(curr.getRight());
					prev = curr;
					// curr = prev.getRight();
				} else {
					prev = stk.pop();
					System.out.println(prev.getData() + " ");
					// curr = stk.top();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
