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

	public int depth(BinaryTreeNode root) {
		if (root == null)
			return 0;
		int left = size(root.getLeft());
		int right = size(root.getRight());
		if (left > right)
			return left + 1;
		else
			return right + 1;
	}

	public int size(BinaryTreeNode root) {
		int count;
		if (root != null)
			count = 1;
		else
			count = 0;
		return count + size(root.getLeft()) + size(root.getRight());
	}

	public int size_ite(BinaryTreeNode root) {
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
