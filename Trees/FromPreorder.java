package Algorithms;

import Implementation.*;

/**
 * leaves are marked as 'LL' and internal nodes are 'I'. preorder traversal is
 * given.
 * 
 * @author pavithraraghavan
 *
 */
public class FromPreorder {
	public BinaryTreeNode buildFromPreoder(char[] input, int i) {
		if (input == null || input.length == i)
			return null;
		BinaryTreeNode node = new BinaryTreeNode(0);
		node.setData(input[i]);
		node.setLeft(null);
		node.setRight(null);
		if (input[i] == 'L')
			return node;
		i++;
		node.setLeft(buildFromPreoder(input, i));
		i++;
		node.setRight(buildFromPreoder(input, i));
		return node;
	}
}
