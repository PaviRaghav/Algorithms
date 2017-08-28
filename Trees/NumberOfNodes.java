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

	public static int diameterOfTree(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int dia = 0;
		Q_DynArray<BinaryTreeNode> q = new Q_DynArray<BinaryTreeNode>();
		q.Enqueue(root);
		while(!q.isEmpty()){
			BinaryTreeNode temp = q.Dequeue();
			if(temp!=null){
				if(temp.getLeft()==null && temp.getRight()==null) q.Enqueue(null);
				if(temp.getLeft()!=null) q.Enqueue(temp.getLeft());
				if(temp.getRight()!=null) q.Enqueue(temp.getRight());
			}
				
			
		}
		return dia;
	}

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(2);
		root.right = new BinaryTreeNode(3);
		root.left.left = new BinaryTreeNode(4);
		root.left.right = new BinaryTreeNode(4);
		root.right.left = new BinaryTreeNode(5);
		root.right.right = new BinaryTreeNode(6);
		root.right.right.right = new BinaryTreeNode(7);
		// levelOrderTraversal(root);
		System.out.println(noOfFullNodes(root));
	}
}
