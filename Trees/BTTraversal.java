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
			boolean flag = false;
			BinaryTreeNode curr = root, prev = null;
			while (!flag) {
				if (curr != null && curr != prev) {
					stk.push(curr);
					curr = curr.getLeft();
				} else {
					if (stk.isEmpty())
						flag = true;
					else {
						BinaryTreeNode temp = stk.top();
						if (curr == temp.getRight()) {
							temp = stk.pop();
							System.out.println(temp.getData());
							prev = temp;
							curr = stk.top();
						}
						if (curr.getRight() != null)
							curr = curr.getRight();
					}
				}
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
				if ((curr != null) && (prev == null || prev.getLeft() == curr || prev.getRight() == curr)) {
					if (curr.getLeft() != null)
						stk.push(curr.getLeft());
					prev = curr;
					curr = curr.getLeft();
				} else if ((curr == null && stk.top().getRight() != null) || curr.getLeft() == prev) {
					stk.push(stk.top().getRight());
					prev = stk.top();
					curr = prev.getRight();
				} else {
					prev = stk.pop();
					System.out.println(prev.getData() + " ");
					curr = stk.top();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		/*
		 * BinaryTreeNode root = new BinaryTreeNode(1); root.left = new
		 * BinaryTreeNode(2); root.right = new BinaryTreeNode(3); root.left.left
		 * = new BinaryTreeNode(4); root.left.right = new BinaryTreeNode(5);
		 * root.left.left.left = new BinaryTreeNode(6); root.left.right.left =
		 * new BinaryTreeNode(7); root.left.right.left.left = new
		 * BinaryTreeNode(10); root.left.right.left.right = new
		 * BinaryTreeNode(8); root.left.right.left.right.right = new
		 * BinaryTreeNode(9); ite_PostOrder(root);
		 */
		int i = 0;
		for (; i < 8; i += 4) {
		}
		System.out.println(i);
	}
}
