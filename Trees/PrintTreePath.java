package Algorithms;

import Implementation.*;

public class PrintTreePath {
	public static void printPaths(BinaryTreeNode root, int[] path, int pathLen) {
		if (root == null)
			return;
		path[pathLen] = root.getData();
		pathLen++;
		if (root.getLeft() == null && root.getRight() == null)
			printArray(path, pathLen);
		else {
			printPaths(root.getLeft(), path, pathLen);
			printPaths(root.getRight(), path, pathLen);
		}
	}

	private static void printArray(int[] ints, int len) {
		for (int i = 0; i < len; i++)
			System.out.println(ints[i] + " ");
		System.out.println();
	}
}
