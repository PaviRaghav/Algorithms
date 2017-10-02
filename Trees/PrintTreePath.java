package Algorithms;

import Implementation.*;

public class PrintTreePath {
	public static void printPaths(BinaryTreeNode root, int[] path, int pathLen) {
		if (root == null)
			return;
		path[pathLen]=root.getData();
		pathLen++;
		if(root.getLeft()==null && root.getRight()==null)
			printArray(path,pathLen);
		else {printPaths(root.getLeft(),path,pathLen);
		printPaths(root.getRight(),path,pathLen);}
	}
	
	private void printArray(int[] ints, int len) {
		
	}
}
