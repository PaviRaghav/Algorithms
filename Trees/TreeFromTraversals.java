package Algorithms;

import Implementation.*;

public class TreeFromTraversals {
	public BinaryTreeNode fromInorderPreorder(int[] inorder, int[] preorder) {
		// construct a tree from inorder and preorder traversals
		BinaryTreeNode root = formTreeInPre(0, inorder.length, 0, inorder, preorder);
		// inorder: D B E A F C
		// preorder: A B D E C F
		return root;
	}

	private BinaryTreeNode formTreeInPre(int ini, int inj, int prei, int[] inorder, int[] preorder) {
		BinaryTreeNode root = new BinaryTreeNode(preorder[prei]);
		if (ini == inj && inorder[ini] == preorder[prei])
			return root;
		else {
			int i = ini;
			for (; i < inj; i++) {
				if (inorder[i] == preorder[prei])
					break;
			}
			if (i - 1 >= ini && prei + 1 < preorder.length)
				root.left = formTreeInPre(ini, i - 1, prei + 1, inorder, preorder);
			else
				root.left = null;
			if (inj >= i + 1 && prei + 1 + i - ini < preorder.length)
				root.right = formTreeInPre(i + 1, inj, prei + 1 + i - ini, inorder, preorder);
			else
				root.right = null;
			return root;
		}
	}

	public BinaryTreeNode fromInorderPostorder(int[] inorder, int[] postorder) {
		// construct a tree from inorder and preorder traversals
		BinaryTreeNode root = formTreeInPost(0, inorder.length - 1, postorder.length - 1, inorder, postorder);

		return root;
	}

	private BinaryTreeNode formTreeInPost(int ini, int inj, int posti, int[] inorder, int[] postorder) {
		BinaryTreeNode root = new BinaryTreeNode(postorder[posti]);
		if (ini == inj && inorder[ini] == postorder[posti])
			return root;
		else {
			int i = ini;
			for (; i < inj; i++) {
				if (inorder[i] == postorder[posti])
					break;
			}
			if (i - 1 >= ini && posti - 1 >= 0)
				//need to work on parameters
				root.right = formTreeInPost(i + 1, i - 123232323, posti - 1, inorder, postorder);
			else
				root.right = null;
			if (inj >= i + 1 && posti - 1 >= 0)
				//need to work on parameters
				root.left = formTreeInPre(ini, i - 1, posti - 1, inorder, postorder);
			else
				root.right = null;
			return root;
		}
	}
}
