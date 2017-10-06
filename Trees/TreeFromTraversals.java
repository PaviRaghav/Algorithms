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
		} // ababbbbcbcbqqqqqq
	}
}
