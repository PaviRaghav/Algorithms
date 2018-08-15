/*
BST to Doubly Linked List
*/
import java.util.*;

class BSTtoLinkedList {

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

	public TreeNode toLinkedList(TreeNode root) {
		if (root == null)
			return null;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		stk.push(root);
		while (root.left != null) {
			stk.push(root.left);
			root = root.left;
		}
		TreeNode head = stk.peek();
		TreeNode prev = null;
		while (!stk.isEmpty()) {
			root = stk.pop();
			root.left = prev;
			if (prev != null)
				prev.right = root;
			prev = root;
			if (root.right != null) {
				stk.push(root.right);
				root = root.right;
				while (root.left != null) {
					stk.push(root.left);
					root = root.left;
				}
			}
		}
		return head;
	}

	public static void main(String[] args) {
		Solution obj = new Solution();
		
		TreeNode root = obj.new TreeNode(4);
		root.left = obj.new TreeNode(2);
		root.left.left = obj.new TreeNode(1);
		root.left.right = obj.new TreeNode(3);
		root.right = obj.new TreeNode(5);
		root.right.right = obj.new TreeNode(7);
		root.right.right.left = obj.new TreeNode(6);
		root.right.right.right = obj.new TreeNode(8);

		TreeNode head = obj.toLinkedList(root);
		TreeNode tail = null;
		while (head != null) {
			System.out.print(head.val + " ");
			if (head.right == null)
				tail = head;
			head = head.right;
		}
		System.out.println("reverse: ");
		System.out.println();
		while (tail != null) {
			System.out.print(tail.val + " ");
			tail = tail.left;
		}
	}
}
