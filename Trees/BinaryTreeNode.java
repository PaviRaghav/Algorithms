package Implementation;

public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left, right;

	public BinaryTreeNode(int item) {
		this.data = item;
		this.left = null;
		this.right = null;
	}

	public int getData() {
		return this.data;
	}

	public void setData(int item) {
		this.data = item;
	}

	public void setLeft(BinaryTreeNode item) {
		this.left = item;
	}

	public BinaryTreeNode getLeft() {
		return this.left;
	}

	public void setRight(BinaryTreeNode item) {
		this.right = item;
	}

	public BinaryTreeNode getRight() {
		return this.right;
	}
}
