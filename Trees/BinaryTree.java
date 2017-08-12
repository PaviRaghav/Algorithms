package Implementation;

public class BinaryTree {
	private BinaryTreeNode root;

	public BinaryTree() {
		root = null;
	}

	public void insert(int data) {
		if (this.root == null)
			root = new BinaryTreeNode(data);
		else
			insert(this.root, data);
	}

	public BinaryTreeNode insert(BinaryTreeNode node, int data) {
		if (node == null)
			node = new BinaryTreeNode(data);
		else {
			if (node.getData() < data)
				node.setRight(insert(node.getRight(), data));
			else
				node.setLeft(insert(node.getLeft(), data));
		}
		return node;
	}

	public void insert_ite(int data) {
		BinaryTreeNode newOne = new BinaryTreeNode(data);
		if (this.root == null)
			this.root = newOne;
		else {
			BinaryTreeNode temp = this.root;
			while (temp != null) {
				if (temp.getData() > data) {
					if (temp.getLeft() != null)
						temp = temp.getLeft();
					else {
						temp.setLeft(newOne);
						break;
					}
				} else {
					if (temp.getRight() != null)
						temp = temp.getRight();
					else {
						temp.setRight(newOne);
						break;
					}
				}
			}
		}
	}

	public void PreOrder(BinaryTreeNode root) {
		while (root != null) {
			System.out.println(root.getData());
			PreOrder(root.getLeft());
			PreOrder(root.getRight());
		}
	}

	public void InOrder(BinaryTreeNode root) {
		while (root != null) {
			InOrder(root.getLeft());
			System.out.println(root.getData());
			InOrder(root.getRight());
		}
	}
}
