package Algorithms;

public class NonMatchingLeaf {

	/*
	 * Given 2 binary trees, return the first pair of non-matching leaves
	 */
	static class ListNode {
		int data;
		ListNode next;

		public ListNode(int item) {
			this.data = item;
			this.next = null;
		}
	}

	static class List {
		ListNode head;

		public List(ListNode item) {
			this.head = item;
		}

		public void addLast(ListNode item) {
			ListNode temp = this.head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = item;
		}
	}

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int item) {
			this.data = item;
			this.left = null;
			this.right = null;
		}
	}

	public void nonMatchingLeaves(TreeNode root1, TreeNode root2) {
		ListNode head1 = new ListNode(-1), temp1 = head1;
		ListNode head2 = new ListNode(-1), temp2 = head2;
		findLeaves(root1, head1);
		findLeaves(root2, head2);
		head1 = temp1.next;
		head2 = temp2.next;

		while (temp1.data == temp2.data) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		if (temp1.data != temp2.data)
			System.out.print(temp1.data + ", " + temp2.data);
	}

	private void findLeaves(TreeNode root, ListNode head) {
		if (root.left == null && root.right == null) {
			List obj = new List(head);
			obj.addLast(new ListNode(root.data));
		}
		if (root.left != null)
			findLeaves(root.left, head);
		if (root.right != null)
			findLeaves(root.right, head);
	}

	public static void main(String[] args) {
		NonMatchingLeaf obj = new NonMatchingLeaf();
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(4);
		root2.right = new TreeNode(2);
		obj.nonMatchingLeaves(root1, root2);
	}
}
