package Implementation;

public class BinaryTree {
	private BinaryTreeNode root;

	public BinaryTree() {
		root = null;
	}

	public void insert_BST(int data) {
		if (this.root == null)
			root = new BinaryTreeNode(data);
		else
			insert_BST(this.root, data);
	}

	public BinaryTreeNode insert_BST(BinaryTreeNode node, int data) {
		if (node == null)
			node = new BinaryTreeNode(data);
		else {
			if (node.getData() < data)
				node.setRight(insert_BST(node.getRight(), data));
			else
				node.setLeft(insert_BST(node.getLeft(), data));
		}
		return node;
	}

	public void insert_BT_ite(int data) {
		Q_DynArray<BinaryTreeNode> q = new Q_DynArray<BinaryTreeNode>();
		BinaryTreeNode new_node = new BinaryTreeNode(data);
		boolean flag = true;
		if (root == null)
			root = new_node;
		while (flag) {
			BinaryTreeNode temp = q.Dequeue();
			if (temp.getLeft() == null) {
				temp.setLeft(new_node);
				flag = false;
			} else if (temp.getLeft() != null)
				q.Enqueue(temp.getLeft());
			else if (temp.getRight() == null) {
				temp.setRight(new_node);
				flag = false;
			} else
				q.Enqueue(temp.getRight());
		}
	}

	public void insert_BST_ite(int data) {
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

	public static int depth(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int left = depth(root.getLeft());
		int right = depth(root.getRight());
		if (left > right)
			return left + 1;
		else
			return right + 1;
	}

	public static int depth_ite(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int max = 0;
		Stack_DynArray<BinaryTreeNode> stk = new Stack_DynArray<BinaryTreeNode>();
		BinaryTreeNode curr, prev = null;
		try {
			stk.push(root);
			while (!stk.isEmpty()) {
				curr = stk.top();
				if (prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
					if (curr.getLeft() != null)
						stk.push(curr.getLeft());
					else if (curr.getRight() != null)
						stk.push(curr.getRight());
				} else if (prev == curr.getLeft()) {
					if (curr.getRight() != null)
						stk.push(curr.getRight());
				} else
					stk.pop();
				prev = curr;
				if (max < stk.size())
					max = stk.size();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return max;
	}

	public static int depth_levelorder(BinaryTreeNode root) {
		if (root == null)
			return 0;
		Q_DynArray<BinaryTreeNode> q = new Q_DynArray<BinaryTreeNode>();
		// BinaryTreeNode nul = new BinaryTreeNode(0);
		q.Enqueue(root);
		q.Enqueue(null);
		int depth = 0;
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.Dequeue();
			if (temp != null) {
				if (temp.getLeft() != null)
					q.Enqueue(temp.getLeft());
				if (temp.getRight() != null)
					q.Enqueue(temp.getRight());
			} else {
				depth++;
				if (!q.isEmpty()) {
					q.Enqueue(null);
				}
			}
		}
		return depth;
	}

	public static int depth_min(BinaryTreeNode root) {
		if (root == null)
			return 0;
		Q_DynArray<BinaryTreeNode> q = new Q_DynArray<BinaryTreeNode>();
		// BinaryTreeNode nul = new BinaryTreeNode(0);
		q.Enqueue(root);
		q.Enqueue(null);
		int depth = 0;
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.Dequeue();
			if (temp != null) {
				if (temp.getLeft() == null && temp.getRight() == null)
					return depth + 1;
				if (temp.getLeft() != null)
					q.Enqueue(temp.getLeft());
				if (temp.getRight() != null)
					q.Enqueue(temp.getRight());
			} else {
				depth++;
				if (!q.isEmpty()) {
					q.Enqueue(null);
				}
			}
		}
		return depth;
	}

	public static int size(BinaryTreeNode root) {
		if (root == null)
			return 0;
		else
			return 1 + size(root.getLeft()) + size(root.getRight());
	}

	public static int size_ite(BinaryTreeNode root) {
		if (root == null)
			return 0;
		Q_DynArray<BinaryTreeNode> q = new Q_DynArray<BinaryTreeNode>();
		q.Enqueue(root);
		int count = 1;
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.Dequeue();
			if (temp.getLeft() != null) {
				count++;
				q.Enqueue(temp.getLeft());
			}
			if (temp.getRight() != null) {
				count++;
				q.Enqueue(temp.getRight());
			}
		}
		return count;
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

	public int maxBinTree_ite(BinaryTreeNode root) {
		Q_DynArray<BinaryTreeNode> q = new Q_DynArray<BinaryTreeNode>();
		if (root == null)
			throw new IllegalStateException("Tree is empty");
		int max = Integer.MIN_VALUE;
		q.Enqueue(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.Dequeue();
			if (max < temp.getData())
				max = temp.getData();
			if (temp.getLeft() != null)
				q.Enqueue(temp.getLeft());
			if (temp.getRight() != null)
				q.Enqueue(temp.getRight());
		}
		return max;
	}

	public boolean searchBinTree(BinaryTreeNode root, int data) {
		if (root == null)
			return false;
		if (root.getData() == data)
			return true;
		else {
			return searchBinTree(root.getLeft(), data) || searchBinTree(root.getRight(), data);
		}
	}

	public boolean searchBinTree_ite(BinaryTreeNode root, int data) {
		Q_DynArray<BinaryTreeNode> q = new Q_DynArray<BinaryTreeNode>();
		if (root == null)
			throw new IllegalStateException("Tree is empty");
		q.Enqueue(root);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.Dequeue();
			if (temp.getData() == data)
				return true;
			if (temp.getLeft() != null)
				q.Enqueue(temp.getLeft());
			if (temp.getRight() != null)
				q.Enqueue(temp.getRight());
		}
		return false;
	}
}
