package Algorithms;

import Implementation.*;

public class TreeFromTraversals {
	public BinaryTreeNode fromInorderPreorder(int[] inorder, int[] preorder) {
		// construct a tree from inorder and preorder traversals
		BinaryTreeNode root = new BinaryTreeNode(1);
		// inorder: D B E A F C
		// preorder: A B D E C F

		return root;
	}

	private BinaryTreeNode formTreeInPre(int ini, int inj, int prei, int[] inorder, int[] preorder) {
		BinaryTreeNode root = new BinaryTreeNode(preorder[prei]);
		int i = ini;
		for (; i < inj; i++) {
			if (inorder[i] == preorder[prei])
				break;
		}
		if(ini==inj)  return root;
		else {
			root.left = formTreeInPre(ini, i - 1, prei + 1, inorder, preorder);
			root.right = formTreeInPre(i + 1, inj, prei + i-ini, inorder, preorder);
			return root;
		}//ababbbbcbcbqqqqqq
	}
}
