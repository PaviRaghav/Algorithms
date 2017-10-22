package Algorithms;

import Implementation.*;

public class HeapSort {
	public int[] sortArray(int[] A) {
		if (A.length <= 1)
			return A;
		Heap obj = new Heap(A);
		int temp = 0;
		for (int i = A.length - 1; i > 0; i--) {
			temp = A[i];
			A[i] = A[0];
			A[0] = temp;
			obj.size--;
			obj.percolateDown(0);
		}
		return A;
	}
}
