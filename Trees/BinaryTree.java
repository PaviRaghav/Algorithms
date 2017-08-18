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
		while (root != null) {
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

	public void PostOrder(BinaryTreeNode root) {
		while (root != null) {
			PostOrder(root.getLeft());
			PostOrder(root.getRight());
			System.out.println(root.getData());
		}
	}

	public void ite_PostOrder(BinaryTreeNode root) {
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
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.Dequeue();
			System.out.println(temp.getData());
			if (temp.getLeft() != null)
				q.Enqueue(temp.getLeft());
			if (temp.getRight() != null)
				q.Enqueue(temp.getRight());
		}
	}

	public int maxInBinaryTree(BinaryTreeNode root) {
		if (root.getLeft() == null && root.getRight() == null)
			return 0;
		else if (root.getLeft() == null)
			return root.getRight().getData();
		else if (root.getRight() == null)
			return root.getLeft().getData();
		else {
			return Math.max(maxInBinaryTree(root.getLeft()), maxInBinaryTree(root.getRight()));
		}
	}
}
