package Algorithms;

import Implementation.*;

public class SumInTree {
	public void kSumFromRoot(BinaryTreeNode root, int sum) {
		int[] arr = new int[1000];
		printPaths(root, sum, arr, 0);
	}

	private void printPaths(BinaryTreeNode root, int sum, int[] arr, int len) {
		arr[len] = root.getData();
		len++;
		if (root.getLeft() == null && root.getRight() == null) {
			if (sum == root.getData()) {
				// print the node & everything from root
				printArray(arr, len);
			} else {
				// don't print. discard this path from root to leaf
				return;
			}
		} else {
			if (root.getLeft() != null)
				printPaths(root.getLeft(), sum - root.getData(), arr, len);
			if (root.getRight() != null)
				printPaths(root.getRight(), sum - root.getData(), arr, len);
		}
	}

	private void printArray(int[] arr, int len) {
		for (int i = 0; i < len; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
